package ru.mirea.lyulcheva.recyclerviewapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<HistoricalEvent> events = getEvents();
        recyclerView.setAdapter(new HistoricalEventAdapter(events));
    }

    private List<HistoricalEvent> getEvents() {
        List<HistoricalEvent> list = new ArrayList<>();

        list.add(new HistoricalEvent("Падение Римской империи", "476 год — конец античности.", "rome"));
        list.add(new HistoricalEvent("Крещение Руси", "988 год — принятие христианства.", "rus"));
        list.add(new HistoricalEvent("Открытие Америки", "1492 — Колумб достиг Нового Света.", "columbus"));
        list.add(new HistoricalEvent("Французская революция", "1789 — начало новой эпохи Европы.", "revolution"));
        list.add(new HistoricalEvent("Первый полёт в космос", "1961 — Юрий Гагарин.", "gagarin"));

        return list;
    }
}