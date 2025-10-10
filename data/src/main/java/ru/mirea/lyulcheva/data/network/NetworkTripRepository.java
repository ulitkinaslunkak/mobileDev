package ru.mirea.lyulcheva.data.repository;

import java.util.List;

import ru.mirea.lyulcheva.data.network.NetworkApi;
import ru.mirea.lyulcheva.domain.models.Trip;

public class NetworkTripRepository {
    private final NetworkApi api = new NetworkApi();

    public List<Trip> fetchTrips() {
        return api.getTrips();
    }
}