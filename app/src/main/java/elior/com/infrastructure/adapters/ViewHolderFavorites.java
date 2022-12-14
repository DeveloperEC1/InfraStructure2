package elior.com.infrastructure.adapters;

import androidx.recyclerview.widget.RecyclerView;

import elior.com.infrastructure.databinding.AdapterEventsFavoritesBinding;

public class ViewHolderFavorites extends RecyclerView.ViewHolder {

    public AdapterEventsFavoritesBinding binding;

    public ViewHolderFavorites(AdapterEventsFavoritesBinding itemBinding) {
        super(itemBinding.getRoot());

        this.binding = itemBinding;
    }

}