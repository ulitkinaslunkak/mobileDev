package ru.mirea.lyulcheva.fragmentapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.lyulcheva.fragmentapp.R;
import ru.mirea.lyulcheva.fragmentapp.model.Task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        CheckBox check;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTaskTitle);
            check = itemView.findViewById(R.id.checkTask);
        }
    }

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task t = tasks.get(position);
        holder.title.setText(t.getTitle());
        holder.check.setChecked(t.isDone());

        holder.check.setOnCheckedChangeListener((buttonView, isChecked) -> {
            t.setDone(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
