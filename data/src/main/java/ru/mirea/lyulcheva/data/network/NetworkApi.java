package ru.mirea.lyulcheva.data.network;

import java.util.Arrays;
import java.util.List;

import ru.mirea.lyulcheva.domain.models.Trip;

public class NetworkApi {

    public List<Trip> getTrips() {
        return Arrays.asList(
                new Trip(1, "Москва – Питер"),
                new Trip(2, "Казань – Сочи"),
                new Trip(3, "Омск – Байкал")
        );
    }
}
