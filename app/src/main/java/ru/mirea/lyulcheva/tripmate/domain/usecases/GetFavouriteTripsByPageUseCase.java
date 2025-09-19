package ru.mirea.lyulcheva.tripmate.domain.usecases;
import java.util.List;
import ru.mirea.lyulcheva.tripmate.domain.models.Trip;
import ru.mirea.lyulcheva.tripmate.domain.repository.TripRepository;
public class GetFavouriteTripsByPageUseCase {
    private final TripRepository repository;

    public GetFavouriteTripsByPageUseCase(TripRepository repository) {
        this.repository = repository;
    }

    public List<Trip> execute(int page, int pageSize) {
        return repository.getFavouriteTripsByPage(page, pageSize);
    }
}