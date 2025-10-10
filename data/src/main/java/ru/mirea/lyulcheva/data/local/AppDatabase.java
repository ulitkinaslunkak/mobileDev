package ru.mirea.lyulcheva.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TripEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TripDao tripDao();
}
