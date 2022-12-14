package elior.com.infrastructure.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import elior.com.infrastructure.MainGraphDirections;
import elior.com.infrastructure.R;
import elior.com.infrastructure.databinding.AdapterEventsMainBinding;
import elior.com.infrastructure.models.Events;

public class EventsMainAdapter extends RecyclerView.Adapter<ViewHolderMain> {

    private final ArrayList<Events> eventsArrayList;

    public EventsMainAdapter(ArrayList<Events> eventsArrayList) {
        this.eventsArrayList = eventsArrayList;
    }

    @NonNull
    @Override
    public ViewHolderMain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterEventsMainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_events_main, parent, false);
        return new ViewHolderMain(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMain holder, final int position) {
        Events event = eventsArrayList.get(position);

        holder.binding.setEvent(event);

        holder.itemView.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(MainGraphDirections.actionNavigateToFavoritesFragment(event));

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

}
