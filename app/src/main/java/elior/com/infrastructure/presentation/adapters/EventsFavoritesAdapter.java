package elior.com.infrastructure.presentation.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import elior.com.infrastructure.R;
import elior.com.infrastructure.data.room.EventsRoom;
import elior.com.infrastructure.databinding.AdapterEventsFavoritesBinding;
import elior.com.infrastructure.presentation.adapters.viewholders.EventsFavoritesViewHolder;

public class EventsFavoritesAdapter extends RecyclerView.Adapter<EventsFavoritesViewHolder> {

    private final ArrayList<EventsRoom> eventsFavoritesArrayList;

    public EventsFavoritesAdapter(ArrayList<EventsRoom> eventsFavoritesArrayList) {
        this.eventsFavoritesArrayList = eventsFavoritesArrayList;
    }

    @NonNull
    @Override
    public EventsFavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterEventsFavoritesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_events_favorites, parent, false);
        return new EventsFavoritesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsFavoritesViewHolder holder, final int position) {
        EventsRoom eventFavorites = eventsFavoritesArrayList.get(position);

        holder.binding.setEventFavorites(eventFavorites);
    }

    @Override
    public int getItemCount() {
        if (eventsFavoritesArrayList != null)
            return eventsFavoritesArrayList.size();
        else return 0;
    }

}
