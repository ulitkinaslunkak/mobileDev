package ru.mirea.lyulcheva.retrofitapp2.network;

import ru.mirea.lyulcheva.retrofitapp2.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    // Получаем список дел
    @GET("todos")
    Call<List<Todo>> getTodos();

    // Обновляем одно дело по ID
    @PUT("todos/{id}")
    Call<Todo> updateTodo(
            @Path("id") int id,
            @Body Todo updatedTodo
    );
}

