package elior.com.infrastructure.adapters;

import androidx.recyclerview.widget.RecyclerView;

import elior.com.infrastructure.databinding.AdapterEventsMainBinding;

public class ViewHolderMain extends RecyclerView.ViewHolder {

    public AdapterEventsMainBinding binding;

    public ViewHolderMain(AdapterEventsMainBinding itemBinding) {
        super(itemBinding.getRoot());

        this.binding = itemBinding;
    }

}