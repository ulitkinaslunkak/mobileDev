package ru.mirea.lyulcheva.tripmate.presentation;
import ru.mirea.lyulcheva.tripmate.R;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ru.mirea.lyulcheva.tripmate.data.repository.TripRepositoryImpl;
import ru.mirea.lyulcheva.tripmate.domain.models.Trip;
import ru.mirea.lyulcheva.tripmate.domain.usecases.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TripRepositoryImpl repository = new TripRepositoryImpl();

        GetTripsUseCase getTrips = new GetTripsUseCase(repository);
        GetTripByIdUseCase getTripById = new GetTripByIdUseCase(repository);
        AddTripUseCase addTrip = new AddTripUseCase(repository);
        EditTripUseCase editTrip = new EditTripUseCase(repository);
        DeleteTripUseCase deleteTrip = new DeleteTripUseCase(repository);
        AddTripsToFavouriteByIdUseCase addToFav = new AddTripsToFavouriteByIdUseCase(repository);
        GetFavouriteTripsByPageUseCase favByPage = new GetFavouriteTripsByPageUseCase(repository);

        addTrip.execute(new Trip(4, "Казань - Сочи"));

        StringBuilder sb = new StringBuilder();
        sb.append("Все поездки:\n");
        for (Trip trip : getTrips.execute()) {
            sb.append(trip.getId()).append(": ").append(trip.getName()).append("\n");
        }

        addToFav.execute(2);

        List<Trip> favourites = favByPage.execute(1, 2);
        sb.append("\nИзбранные поездки:\n");
        for (Trip fav : favourites) {
            sb.append(fav.getId()).append(": ").append(fav.getName()).append("\n");
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(sb.toString());
    }
}
