package ru.mirea.lyulcheva.domain.usecases;

import ru.mirea.lyulcheva.domain.models.Trip;
import ru.mirea.lyulcheva.domain.repository.TripRepository;

public class GetTripByIdUseCase {

    private final TripRepository repository;

    public GetTripByIdUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public Trip execute(int id) {
        return repository.getTripById(id);
    }
}
