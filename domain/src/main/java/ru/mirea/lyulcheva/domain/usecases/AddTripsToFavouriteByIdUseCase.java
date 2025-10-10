package ru.mirea.lyulcheva.domain.usecases;

import ru.mirea.lyulcheva.domain.repository.TripRepository;

public class AddTripsToFavouriteByIdUseCase {
    private final TripRepository repository;

    public AddTripsToFavouriteByIdUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public boolean execute(int id) {
        return repository.addTripToFavourite(id);
    }
}
