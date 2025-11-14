package ru.mirea.lyulcheva.fragmentapp.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.mirea.lyulcheva.fragmentapp.R;
import ru.mirea.lyulcheva.fragmentapp.adapter.TaskAdapter;
import ru.mirea.lyulcheva.fragmentapp.model.Task;

public class TaskListFragment extends Fragment {

    private ArrayList<Task> tasks;

    public TaskListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        tasks = new ArrayList<>();
        tasks.add(new Task("Помыть посуду", false));
        tasks.add(new Task("Сделать лабу 1", true));
        tasks.add(new Task("Сделать практику 2", false));
        tasks.add(new Task("Написать практику 3", false));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new TaskAdapter(tasks));

        return view;
    }
}

