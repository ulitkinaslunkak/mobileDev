package ru.mirea.lyulcheva.tripmate.domain.usecases;

import ru.mirea.lyulcheva.tripmate.domain.repository.TripRepository;

public class AddTripsToFavouriteByIdUseCase {
    private final TripRepository repository;

    public AddTripsToFavouriteByIdUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public boolean execute(int id) {
        return repository.addTripToFavourite(id);
    }
}
