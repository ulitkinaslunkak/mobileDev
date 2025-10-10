package ru.mirea.lyulcheva.tripmate.presentation;
import ru.mirea.lyulcheva.data.repository.NetworkTripRepository;
import ru.mirea.lyulcheva.tripmate.R;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.StringBuilder;

import ru.mirea.lyulcheva.data.repository.TripRepositoryImpl;
import ru.mirea.lyulcheva.domain.models.Trip;
import ru.mirea.lyulcheva.domain.usecases.*;

import ru.mirea.lyulcheva.data.repository.ClientPreferencesRepository;
import ru.mirea.lyulcheva.data.repository.RoomTripRepository;
import ru.mirea.lyulcheva.data.local.*;
import ru.mirea.lyulcheva.data.network.*;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        TripRepositoryImpl repository = new TripRepositoryImpl();
        GetTripsUseCase getTrips = new GetTripsUseCase(repository);
        AddTripUseCase addTrip = new AddTripUseCase(repository);
        AddTripsToFavouriteByIdUseCase addToFav = new AddTripsToFavouriteByIdUseCase(repository);
        GetFavouriteTripsByPageUseCase favByPage = new GetFavouriteTripsByPageUseCase(repository);

        addTrip.execute(new Trip(4, "Казань - Сочи"));
        addToFav.execute(2);

        ClientPreferencesRepository prefs = new ClientPreferencesRepository(this);
        prefs.saveClient("Иван", "ivan@mail.ru");

        RoomTripRepository roomRepo = new RoomTripRepository(this);
        roomRepo.addTrip("Москва – Сочи");
        roomRepo.addTrip("Казань – Уфа");

        NetworkTripRepository netRepo = new NetworkTripRepository();

        StringBuilder sb = new StringBuilder();

        sb.append("Все поездки (UseCase):\n");
        for (Trip trip : getTrips.execute()) {
            sb.append(trip.getId()).append(": ").append(trip.getName()).append("\n");
        }

        List<Trip> favourites = favByPage.execute(1, 2);
        sb.append("\nИзбранные поездки (UseCase):\n");
        for (Trip fav : favourites) {
            sb.append(fav.getId()).append(": ").append(fav.getName()).append("\n");
        }

        List<TripEntity> roomTrips = roomRepo.getAllTrips();
        sb.append("\nПоездки из Room:\n");
        for (TripEntity trip : roomTrips) {
            sb.append(trip.id).append(": ").append(trip.name).append("\n");
        }

        List<Trip> networkTrips = netRepo.fetchTrips();
        sb.append("\nДанные с NetworkApi:\n");
        for (Trip trip : networkTrips) {
            sb.append(trip.getId()).append(": ").append(trip.getName()).append("\n");
        }

        textView.setText(sb.toString());
    }
}
