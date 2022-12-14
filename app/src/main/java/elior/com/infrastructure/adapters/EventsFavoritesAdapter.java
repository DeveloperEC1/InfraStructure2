package elior.com.infrastructure.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import elior.com.infrastructure.R;
import elior.com.infrastructure.databinding.AdapterEventsFavoritesBinding;
import elior.com.infrastructure.room.EventsFavorites;

public class EventsFavoritesAdapter extends RecyclerView.Adapter<ViewHolderFavorites> {

    private final ArrayList<EventsFavorites> eventsFavoritesArrayList;

    public EventsFavoritesAdapter(ArrayList<EventsFavorites> eventsFavoritesArrayList) {
        this.eventsFavoritesArrayList = eventsFavoritesArrayList;
    }

    @NonNull
    @Override
    public ViewHolderFavorites onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterEventsFavoritesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_events_favorites, parent, false);
        return new ViewHolderFavorites(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavorites holder, final int position) {
        EventsFavorites eventFavorites = eventsFavoritesArrayList.get(position);

        holder.binding.setEventFavorites(eventFavorites);
    }

    @Override
    public int getItemCount() {
        if (eventsFavoritesArrayList != null)
            return eventsFavoritesArrayList.size();
        else return 0;
    }

}
