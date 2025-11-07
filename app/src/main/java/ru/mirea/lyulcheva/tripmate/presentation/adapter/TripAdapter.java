package ru.mirea.lyulcheva.tripmate.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import ru.mirea.lyulcheva.tripmate.R;
import ru.mirea.lyulcheva.domain.models.Trip;
import android.widget.ImageView;
public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    private List<Trip> trips;

    public TripAdapter(List<Trip> trips) { this.trips = trips; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trip, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Trip trip = trips.get(position);
        holder.tripName.setText(trip.getName());
        holder.tripDescription.setText(trip.getDescription());

        int resId = holder.itemView.getContext().getResources()
                .getIdentifier(trip.getImageName(), "drawable", holder.itemView.getContext().getPackageName());
        holder.tripIcon.setImageResource(resId != 0 ? resId : R.drawable.ic_trip);
    }

    @Override
    public int getItemCount() { return trips.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView tripIcon;
        TextView tripName, tripDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tripIcon = itemView.findViewById(R.id.tripIcon);
            tripName = itemView.findViewById(R.id.tripName);
            tripDescription = itemView.findViewById(R.id.tripDescription);
        }
    }

    public void updateData(List<Trip> newTrips) {
        this.trips = newTrips;
        notifyDataSetChanged();
    }
}
