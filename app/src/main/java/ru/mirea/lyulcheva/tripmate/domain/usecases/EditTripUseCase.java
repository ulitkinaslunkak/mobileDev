package ru.mirea.lyulcheva.tripmate.domain.usecases;

import ru.mirea.lyulcheva.tripmate.domain.models.Trip;
import ru.mirea.lyulcheva.tripmate.domain.repository.TripRepository;

public class EditTripUseCase {
    private final TripRepository repository;

    public EditTripUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public boolean execute(Trip trip) {
        return repository.editTrip(trip);
    }
}