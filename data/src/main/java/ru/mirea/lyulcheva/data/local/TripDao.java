package ru.mirea.lyulcheva.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TripDao {
    @Insert
    void insert(TripEntity trip);

    @Query("SELECT * FROM trips")
    List<TripEntity> getAllTrips();

    @Query("DELETE FROM trips WHERE id = :tripId")
    void deleteTrip(int tripId);
}
