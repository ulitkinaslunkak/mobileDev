package ru.mirea.lyulcheva.tripmate.presentation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.lyulcheva.tripmate.R;
import ru.mirea.lyulcheva.domain.models.Trip;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        viewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @Override
            public <T extends ViewModel> T create(Class<T> modelClass) {
                return (T) new MainViewModel(getApplicationContext());
            }
        }).get(MainViewModel.class);

        viewModel.getTrips().observe(this, this::updateTrips);
        viewModel.getFavouriteTrips().observe(this, this::updateFavouriteTrips);
//        viewModel.getRoomTrips().observe(this, this::updateRoomTrips);
//        viewModel.getNetworkTrips().observe(this, this::updateNetworkTrips);
        viewModel.getCombinedTrips().observe(this, this::updateCombinedTrips);
        viewModel.getStatus().observe(this, status -> textView.append("\n" + status));

        viewModel.loadTrips();
        viewModel.loadFavouriteTrips(1, 2);
        viewModel.loadRoomTrips();
        viewModel.loadNetworkTrips();

        viewModel.addTrip(new Trip(4, "Казань – Сочи"));
        viewModel.addTripToFavourite(2);
        viewModel.saveClient("Иван", "ivan@mail.ru");
        //viewModel.addRoomTrip("Москва – Сочи");
        //viewModel.addRoomTrip("Казань – Уфа");
    }

    private void updateTrips(List<Trip> trips) {
        textView.append("\nВсе поездки (UseCase):\n");
        for (Trip trip : trips) textView.append(trip.getId() + ": " + trip.getName() + "\n");
    }

    private void updateFavouriteTrips(List<Trip> favourites) {
        textView.append("\nИзбранные поездки (UseCase):\n");
        for (Trip trip : favourites) textView.append(trip.getId() + ": " + trip.getName() + "\n");
    }

//    private void updateRoomTrips(List<TripEntity> roomTrips) {
//        textView.append("\nПоездки из Room:\n");
//        for (TripEntity trip : roomTrips) textView.append(trip.id + ": " + trip.name + "\n");
//    }

//    private void updateNetworkTrips(@NonNull List<Trip> networkTrips) {
//        textView.append("\nДанные с NetworkApi:\n");
//        for (Trip trip : networkTrips) textView.append(trip.getId() + ": " + trip.getName() + "\n");
//    }

    private boolean combinedDisplayed = false;

    private void updateCombinedTrips(List<Trip> combined) {
        if (combinedDisplayed) return;
        combinedDisplayed = true;

        textView.append("\nОбъединённые Room + Network:\n");
        for (Trip trip : combined) {
            textView.append(trip.getId() + ": " + trip.getName() + "\n");
        }
    }
}

