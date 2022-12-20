package elior.com.infrastructure.presentation.adapters.viewholders;

import androidx.recyclerview.widget.RecyclerView;

import elior.com.infrastructure.databinding.AdapterEventsFavoritesBinding;

public class EventsFavoritesViewHolder extends RecyclerView.ViewHolder {

    public AdapterEventsFavoritesBinding binding;

    public EventsFavoritesViewHolder(AdapterEventsFavoritesBinding itemBinding) {
        super(itemBinding.getRoot());

        binding = itemBinding;
    }

}
