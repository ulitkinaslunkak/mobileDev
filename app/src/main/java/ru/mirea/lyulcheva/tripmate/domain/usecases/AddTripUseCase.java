package ru.mirea.lyulcheva.tripmate.domain.usecases;

import ru.mirea.lyulcheva.tripmate.domain.models.Trip;
import ru.mirea.lyulcheva.tripmate.domain.repository.TripRepository;

public class AddTripUseCase {
    private final TripRepository repository;

    public AddTripUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public boolean execute(Trip trip) {
        return repository.addTrip(trip);
    }
}
