package ru.mirea.lyulcheva.tripmate.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import ru.mirea.lyulcheva.tripmate.R;
import ru.mirea.lyulcheva.domain.models.Trip;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    private List<Trip> trips;

    public TripAdapter(List<Trip> trips) {
        this.trips = trips;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip, parent, false);
        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip trip = trips.get(position);
        holder.name.setText(trip.getName());
        holder.description.setText(trip.getDescription());

        Picasso.get()
                .load(trip.getImageName()) // теперь это URL
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_image)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    public void updateData(List<Trip> newTrips) {
        trips.clear();
        trips.addAll(newTrips);
        notifyDataSetChanged();
    }

    static class TripViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.trip_name);
            description = itemView.findViewById(R.id.trip_description);
            image = itemView.findViewById(R.id.trip_image);
        }
    }
}


