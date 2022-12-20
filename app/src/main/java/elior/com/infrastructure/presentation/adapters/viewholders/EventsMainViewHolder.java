package elior.com.infrastructure.presentation.adapters.viewholders;

import androidx.recyclerview.widget.RecyclerView;

import elior.com.infrastructure.databinding.AdapterEventsMainBinding;

public class EventsMainViewHolder extends RecyclerView.ViewHolder {

    public AdapterEventsMainBinding binding;

    public EventsMainViewHolder(AdapterEventsMainBinding itemBinding) {
        super(itemBinding.getRoot());

        binding = itemBinding;
    }

}
