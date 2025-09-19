package ru.mirea.lyulcheva.tripmate.domain.usecases;

import ru.mirea.lyulcheva.tripmate.domain.models.Trip;
import ru.mirea.lyulcheva.tripmate.domain.repository.TripRepository;

public class GetTripByIdUseCase {

    private final TripRepository repository;

    public GetTripByIdUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public Trip execute(int id) {
        return repository.getTripById(id);
    }
}
