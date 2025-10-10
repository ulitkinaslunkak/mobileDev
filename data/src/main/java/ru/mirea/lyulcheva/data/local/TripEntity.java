package ru.mirea.lyulcheva.data.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trips")
public class TripEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    public TripEntity(String name) {
        this.name = name;
    }
}
