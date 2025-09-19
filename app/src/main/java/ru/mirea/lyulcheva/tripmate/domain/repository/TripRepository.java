package ru.mirea.lyulcheva.tripmate.domain.repository;

import ru.mirea.lyulcheva.tripmate.domain.models.Trip;
import java.util.List;

public interface TripRepository {
    List<Trip> getTrips();
    Trip getTripById(int id);
    boolean addTrip(Trip trip);
    boolean editTrip(Trip trip);
    boolean deleteTrip(int id);
    boolean addTripToFavourite(int id);
    List<Trip> getFavouriteTripsByPage(int page, int pageSize);
}