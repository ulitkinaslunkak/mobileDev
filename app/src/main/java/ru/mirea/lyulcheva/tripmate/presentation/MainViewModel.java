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
import ru.mirea.lyulcheva.domain.usecases.AddTripUseCase;
import ru.mirea.lyulcheva.domain.usecases.AddTripsToFavouriteByIdUseCase;
import ru.mirea.lyulcheva.domain.usecases.DeleteTripUseCase;
import ru.mirea.lyulcheva.domain.usecases.GetFavouriteTripsByPageUseCase;
import ru.mirea.lyulcheva.domain.usecases.GetTripsUseCase;

public class MainViewModel extends ViewModel {

    private final TripRepositoryImpl repository;
    private final MutableLiveData<List<Trip>> trips = new MutableLiveData<>();
    private final Executor executor = Executors.newSingleThreadExecutor();

    public MainViewModel(Context context) {
        repository = new TripRepositoryImpl();
        loadMockTrips();
    }

    public LiveData<List<Trip>> getMockTrips() { return trips; }

    public void loadMockTrips() {
        executor.execute(() -> trips.postValue(repository.getTrips()));
    }
}
