package ru.mirea.lyulcheva.data.network;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import ru.mirea.lyulcheva.domain.models.Trip;

public interface ApiService {
    @GET("8785cc66-f15c-4ac1-86b4-e0e984653e2d")
    Call<List<Trip>> getTrips();
}