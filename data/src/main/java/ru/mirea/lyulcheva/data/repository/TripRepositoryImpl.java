package ru.mirea.lyulcheva.data.repository;

import ru.mirea.lyulcheva.domain.models.Trip;
import ru.mirea.lyulcheva.domain.repository.TripRepository;

import java.util.ArrayList;
import java.util.List;

public class TripRepositoryImpl implements TripRepository {

    private final List<Trip> trips = new ArrayList<>();

    public TripRepositoryImpl() {
        trips.add(new Trip(1, "Москва - Санкт-Петербург"));
        trips.add(new Trip(2, "Берлин - Париж"));
        trips.add(new Trip(3, "Нью-Йорк - Лос-Анджелес"));
    }

    @Override
    public List<Trip> getTrips() {
        return new ArrayList<>(trips);
    }

    @Override
    public Trip getTripById(int id) {
        for (Trip trip : trips) {
            if (trip.getId() == id) {
                return trip;
            }
        }
        return null;
    }

    @Override
    public boolean addTrip(Trip trip) {
        return trips.add(trip);
    }

    @Override
    public boolean editTrip(Trip updatedTrip) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getId() == updatedTrip.getId()) {
                trips.set(i, updatedTrip);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteTrip(int id) {
        return trips.removeIf(trip -> trip.getId() == id);
    }

    @Override
    public boolean addTripToFavourite(int id) {
        Trip trip = getTripById(id);
        if (trip != null) {
            trip.setFavourite(true);
            return true;
        }
        return false;
    }

    @Override
    public List<Trip> getFavouriteTripsByPage(int page, int pageSize) {
        List<Trip> favourites = new ArrayList<>();
        for (Trip trip : trips) {
            if (trip.isFavourite()) {
                favourites.add(trip);
            }
        }
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, favourites.size());
        if (fromIndex >= favourites.size()) return new ArrayList<>();
        return favourites.subList(fromIndex, toIndex);
    }
}
