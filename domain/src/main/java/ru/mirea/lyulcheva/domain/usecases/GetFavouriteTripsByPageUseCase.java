package ru.mirea.lyulcheva.domain.usecases;
import java.util.List;
import ru.mirea.lyulcheva.domain.models.Trip;
import ru.mirea.lyulcheva.domain.repository.TripRepository;
public class GetFavouriteTripsByPageUseCase {
    private final TripRepository repository;

    public GetFavouriteTripsByPageUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public List<Trip> execute(int page, int pageSize) {
        return repository.getFavouriteTripsByPage(page, pageSize);
    }
}