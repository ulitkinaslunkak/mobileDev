package ru.mirea.lyulcheva.data.repository;

import ru.mirea.lyulcheva.domain.models.Trip;
import ru.mirea.lyulcheva.domain.repository.TripRepository;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import retrofit2.Response;

import ru.mirea.lyulcheva.data.network.ApiService;
import ru.mirea.lyulcheva.data.network.RetrofitClient;

public class TripRepositoryImpl implements TripRepository {

    private final ApiService apiService;

    public TripRepositoryImpl() {
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    @Override
    public List<Trip> getTrips() {
        try {
            Response<List<Trip>> response = apiService.getTrips().execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            } else {
                Log.e("TripRepository", "Ошибка ответа: " + response.code());
                return new ArrayList<>();
            }
        } catch (Exception e) {
            Log.e("TripRepository", "Ошибка сети: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Trip getTripById(int id) {
        return null;
    }

    @Override
    public boolean addTrip(Trip trip) {
        return false;
    }

    @Override
    public boolean editTrip(Trip trip) {
        return false;
    }

    @Override
    public boolean deleteTrip(int id) {
        return false;
    }

    @Override
    public boolean addTripToFavourite(int id) {
        return false;
    }

    @Override
    public List<Trip> getFavouriteTripsByPage(int page, int pageSize) {
        return new ArrayList<>();
    }
}
