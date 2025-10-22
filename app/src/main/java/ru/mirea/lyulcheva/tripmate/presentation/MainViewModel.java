package ru.mirea.lyulcheva.tripmate.presentation;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import ru.mirea.lyulcheva.data.local.TripEntity;
import ru.mirea.lyulcheva.data.repository.ClientPreferencesRepository;
import ru.mirea.lyulcheva.data.repository.NetworkTripRepository;
import ru.mirea.lyulcheva.data.repository.RoomTripRepository;
import ru.mirea.lyulcheva.data.repository.TripRepositoryImpl;
import ru.mirea.lyulcheva.domain.models.Trip;
import ru.mirea.lyulcheva.domain.usecases.*;

public class MainViewModel extends ViewModel {

    private final AddTripUseCase addTripUseCase;
    private final AddTripsToFavouriteByIdUseCase addToFavouriteUseCase;
    private final GetTripsUseCase getTripsUseCase;
    private final GetFavouriteTripsByPageUseCase getFavouriteTripsUseCase;
    private final DeleteTripUseCase deleteTripUseCase;

    private final ClientPreferencesRepository prefs;
    private final RoomTripRepository roomRepo;
    private final NetworkTripRepository networkRepo;

    private final MutableLiveData<List<Trip>> trips = new MutableLiveData<>();
    private final MutableLiveData<List<Trip>> favouriteTrips = new MutableLiveData<>();
    private final MutableLiveData<List<TripEntity>> roomTrips = new MutableLiveData<>();
    private final MutableLiveData<List<Trip>> networkTrips = new MutableLiveData<>();
    private final MediatorLiveData<List<Trip>> combinedTrips = new MediatorLiveData<>();
    private final MutableLiveData<String> status = new MutableLiveData<>();

    private final Executor executor = Executors.newSingleThreadExecutor();

    public MainViewModel(Context context) {
        TripRepositoryImpl repository = new TripRepositoryImpl();

        this.addTripUseCase = new AddTripUseCase(repository);
        this.addToFavouriteUseCase = new AddTripsToFavouriteByIdUseCase(repository);
        this.getTripsUseCase = new GetTripsUseCase(repository);
        this.getFavouriteTripsUseCase = new GetFavouriteTripsByPageUseCase(repository);
        this.deleteTripUseCase = new DeleteTripUseCase(repository);

        this.prefs = new ClientPreferencesRepository(context);
        this.roomRepo = new RoomTripRepository(context);
        this.networkRepo = new NetworkTripRepository();

        combinedTrips.addSource(roomTrips, roomData -> combinedTrips.setValue(mergeTrips(roomData, networkTrips.getValue())));
        combinedTrips.addSource(networkTrips, netData -> combinedTrips.setValue(mergeTrips(roomTrips.getValue(), netData)));
    }

    public LiveData<List<Trip>> getTrips() { return trips; }
    public LiveData<List<Trip>> getFavouriteTrips() { return favouriteTrips; }
    public LiveData<List<TripEntity>> getRoomTrips() { return roomTrips; }
    public LiveData<List<Trip>> getNetworkTrips() { return networkTrips; }
    public LiveData<List<Trip>> getCombinedTrips() { return combinedTrips; }
    public LiveData<String> getStatus() { return status; }

    public void loadTrips() { executor.execute(() -> trips.postValue(getTripsUseCase.execute())); }
    public void loadFavouriteTrips(int page, int pageSize) { executor.execute(() -> favouriteTrips.postValue(getFavouriteTripsUseCase.execute(page, pageSize))); }
    public void addTrip(Trip trip) { executor.execute(() -> { boolean success = addTripUseCase.execute(trip); status.postValue(success ? "Поездка добавлена" : "Ошибка добавления"); loadTrips(); }); }
    public void addTripToFavourite(int tripId) { executor.execute(() -> { boolean success = addToFavouriteUseCase.execute(tripId); status.postValue(success ? "Добавлено в избранное" : "Ошибка"); loadFavouriteTrips(1, 10); }); }
    public void deleteTrip(int tripId) { executor.execute(() -> { boolean success = deleteTripUseCase.execute(tripId); status.postValue(success ? "Поездка удалена" : "Ошибка"); loadTrips(); }); }

    public void saveClient(String name, String email) { executor.execute(() -> { prefs.saveClient(name, email); status.postValue("Клиент сохранён: " + name); }); }

    public void addRoomTrip(String tripName) { executor.execute(() -> { roomRepo.addTrip(tripName); status.postValue("Добавлено в Room: " + tripName); loadRoomTrips(); }); }
    public void loadRoomTrips() { executor.execute(() -> roomTrips.postValue(roomRepo.getAllTrips())); }

    public void loadNetworkTrips() { executor.execute(() -> networkTrips.postValue(networkRepo.fetchTrips())); }

    private List<Trip> mergeTrips(List<TripEntity> roomData, List<Trip> networkData) {
        List<Trip> result = new ArrayList<>();
        if (networkData != null) result.addAll(networkData);
        if (roomData != null) for (TripEntity entity : roomData) result.add(new Trip(entity.id, entity.name));
        return result;
    }
}
