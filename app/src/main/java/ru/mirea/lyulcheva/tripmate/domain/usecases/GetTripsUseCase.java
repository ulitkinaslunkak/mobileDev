package ru.mirea.lyulcheva.tripmate.domain.usecases;

import ru.mirea.lyulcheva.tripmate.domain.models.Trip;
import ru.mirea.lyulcheva.tripmate.domain.repository.TripRepository;
import java.util.List;

public class GetTripsUseCase {
    private final TripRepository repository;

    public GetTripsUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public List<Trip> execute() {
        return repository.getTrips();
    }
}
