package elior.com.infrastructure.presentation.pages.fragments;

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
import elior.com.infrastructure.data.room.EventsRoom;
import elior.com.infrastructure.presentation.adapters.EventsFavoritesAdapter;
import elior.com.infrastructure.databinding.FragmentFavoritesBinding;
import elior.com.infrastructure.data.room.EventsViewModelRoom;

public class FavoritesFragment extends BaseFragment {

    private FragmentFavoritesBinding binding;
    private EventsViewModelRoom eventsViewModelFavorites;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false);

        initUI();
        setData();

        return binding.getRoot();
    }

    private void initUI() {
        eventsViewModelFavorites = new EventsViewModelRoom();
    }

    private void setData() {
        Log.i("getData1", FavoritesGraphArgs.fromBundle(getArguments()).getEventsData().getActivity());
//        Log.i("getData1", ((Events) getArguments().getSerializable("eventsData")).getActivity());

        eventsViewModelFavorites.getAllEvents().observe(getViewLifecycleOwner(), eventsFavorites -> {
            EventsFavoritesAdapter eventsFavoritesAdapter = new EventsFavoritesAdapter((ArrayList<EventsRoom>) eventsFavorites);
            binding.recyclerView.setAdapter(eventsFavoritesAdapter);
        });
    }

}
