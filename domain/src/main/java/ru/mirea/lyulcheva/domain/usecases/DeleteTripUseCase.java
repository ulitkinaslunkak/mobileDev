package ru.mirea.lyulcheva.domain.usecases;

import ru.mirea.lyulcheva.domain.repository.TripRepository;

public class DeleteTripUseCase {
    private final TripRepository repository;

    public DeleteTripUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public boolean execute(int id) {
        return repository.deleteTrip(id);
    }
}

