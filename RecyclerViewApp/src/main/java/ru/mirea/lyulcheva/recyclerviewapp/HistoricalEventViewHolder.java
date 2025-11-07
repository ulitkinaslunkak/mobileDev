package ru.mirea.lyulcheva.recyclerviewapp;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoricalEventViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView titleView;
    TextView descriptionView;

    public HistoricalEventViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageViewEvent);
        titleView = itemView.findViewById(R.id.textViewTitle);
        descriptionView = itemView.findViewById(R.id.textViewDescription);
    }
}
