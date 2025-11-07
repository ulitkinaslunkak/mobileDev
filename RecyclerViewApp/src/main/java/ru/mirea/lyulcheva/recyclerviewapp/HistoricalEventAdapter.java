package ru.mirea.lyulcheva.recyclerviewapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HistoricalEventAdapter extends RecyclerView.Adapter<HistoricalEventViewHolder> {

    private List<HistoricalEvent> events;
    private Context context;

    public HistoricalEventAdapter(List<HistoricalEvent> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public HistoricalEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.event_item_view, parent, false);
        return new HistoricalEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricalEventViewHolder holder, int position) {
        HistoricalEvent event = events.get(position);

        int imgRes = context.getResources().getIdentifier(event.getImageName(), "drawable", context.getPackageName());
        holder.imageView.setImageResource(imgRes);
        holder.titleView.setText(event.getTitle());
        holder.descriptionView.setText(event.getDescription());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
