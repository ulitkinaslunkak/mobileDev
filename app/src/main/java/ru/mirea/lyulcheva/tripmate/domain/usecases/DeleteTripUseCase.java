package ru.mirea.lyulcheva.tripmate.domain.usecases;

import ru.mirea.lyulcheva.tripmate.domain.repository.TripRepository;

public class DeleteTripUseCase {
    private final TripRepository repository;

    public DeleteTripUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public boolean execute(int id) {
        return repository.deleteTrip(id);
    }
}

