package ru.mirea.lyulcheva.domain.usecases;

import ru.mirea.lyulcheva.domain.models.Trip;
import ru.mirea.lyulcheva.domain.repository.TripRepository;

public class AddTripUseCase {
    private final TripRepository repository;

    public AddTripUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public boolean execute(Trip trip) {
        return repository.addTrip(trip);
    }
}
