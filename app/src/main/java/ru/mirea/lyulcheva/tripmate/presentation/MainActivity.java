package ru.mirea.lyulcheva.tripmate.presentation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.lyulcheva.tripmate.R;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import ru.mirea.lyulcheva.tripmate.presentation.adapter.TripAdapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {

    private TripAdapter adapter;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.mockRecycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TripAdapter(new ArrayList<>());
        recycler.setAdapter(adapter);

        viewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            @SuppressWarnings("unchecked")
            public <T extends androidx.lifecycle.ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(getApplicationContext());
            }
        }).get(MainViewModel.class);

        viewModel.getMockTrips().observe(this, trips -> adapter.updateData(trips));
        viewModel.loadMockTrips();
    }
}