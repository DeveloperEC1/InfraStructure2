package elior.com.infrastructure.presentation.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import elior.com.infrastructure.EventsGraphDirections;
import elior.com.infrastructure.R;
import elior.com.infrastructure.databinding.AdapterEventsMainBinding;
import elior.com.infrastructure.data.models.Events;
import elior.com.infrastructure.presentation.adapters.viewholders.EventsMainViewHolder;

public class EventsMainAdapter extends RecyclerView.Adapter<EventsMainViewHolder> {

    private ArrayList<Events> eventsArrayList = new ArrayList<>();

    @NonNull
    @Override
    public EventsMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterEventsMainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_events_main, parent, false);
        return new EventsMainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsMainViewHolder holder, final int position) {
        Events event = eventsArrayList.get(position);

        holder.binding.setEvent(event);

        holder.itemView.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(EventsGraphDirections.actionNavigateToFavoritesFragment(event));

//            Bundle bundle = new Bundle();
//            bundle.putSerializable("eventsData", events);
//            Navigation.findNavController(view).navigate(R.id.action_navigate_to_favorites_fragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        if (eventsArrayList != null)
            return eventsArrayList.size();
        else return 0;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(ArrayList<Events> eventsArrayList) {
        this.eventsArrayList = eventsArrayList;
        notifyDataSetChanged();
    }

}
