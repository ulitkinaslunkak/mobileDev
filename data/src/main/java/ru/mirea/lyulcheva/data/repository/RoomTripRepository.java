package ru.mirea.lyulcheva.data.repository;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import ru.mirea.lyulcheva.data.local.AppDatabase;
import ru.mirea.lyulcheva.data.local.TripEntity;

public class RoomTripRepository {
    private final AppDatabase db;

    public RoomTripRepository(Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "trips_db")
                .allowMainThreadQueries()
                .build();
    }

    public void addTrip(String name) {
        db.tripDao().insert(new TripEntity(name));
    }

    public List<TripEntity> getAllTrips() {
        return db.tripDao().getAllTrips();
    }

    public void deleteTrip(int id) {
        db.tripDao().deleteTrip(id);
    }
}
