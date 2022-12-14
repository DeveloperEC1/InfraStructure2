package elior.com.infrastructure.pages.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;

import elior.com.infrastructure.FavoritesGraphArgs;
import elior.com.infrastructure.R;
import elior.com.infrastructure.adapters.EventsFavoritesAdapter;
import elior.com.infrastructure.databinding.FragmentFavoritesBinding;
import elior.com.infrastructure.room.EventsFavorites;
import elior.com.infrastructure.room.EventsViewModelFavorites;

public class FavoritesFragment extends BaseFragment {

    private FragmentFavoritesBinding binding;
    private EventsViewModelFavorites eventsViewModelFavorites;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false);

        initUI();
        setData();

        return binding.getRoot();
    }

    private void initUI() {
        eventsViewModelFavorites = new EventsViewModelFavorites();
    }

    private void setData() {
        Log.i("getData1", FavoritesGraphArgs.fromBundle(getArguments()).getEventsData().getActivity());
//        Log.i("getData1", ((Events) getArguments().getSerializable("eventsData")).getActivity());

        eventsViewModelFavorites.getAllEvents().observe(getViewLifecycleOwner(), eventsFavorites -> {
            EventsFavoritesAdapter eventsFavoritesAdapter = new EventsFavoritesAdapter((ArrayList<EventsFavorites>) eventsFavorites);
            binding.recyclerView.setAdapter(eventsFavoritesAdapter);
        });
    }

}
