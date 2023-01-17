package elior.com.infrastructure.presentation.pages.fragments;

import static elior.com.infrastructure.core.Constants.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import elior.com.infrastructure.FavoritesGraphArgs;
import elior.com.infrastructure.R;
import elior.com.infrastructure.data.room.EventsViewModelRoom;
import elior.com.infrastructure.databinding.FragmentFavoritesBinding;
import elior.com.infrastructure.presentation.pages.viewmodels.FavoritesViewModel;
import elior.com.infrastructure.presentation.pages.viewmodels.ViewModelManager;

public class FavoritesFragment extends BaseFragment {

    private FragmentFavoritesBinding binding;
    private final FavoritesViewModel favoritesViewModel = ViewModelManager.instance.getFavoritesViewModel();
    private final EventsViewModelRoom eventsViewModelRoom = ViewModelManager.instance.getEventsViewModelRoom();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initDataBinding(inflater, container);
        setData();

        return binding.getRoot();
    }

    private void initDataBinding(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false);
        binding.setFavoritesViewModel(favoritesViewModel);
        binding.setLifecycleOwner(this);
    }

    private void setData() {
        Log.i(TAG, FavoritesGraphArgs.fromBundle(getArguments()).getEventsData().getActivity());
//        Log.i(TAG, ((Events) getArguments().getSerializable("eventsData")).getActivity());

        eventsViewModelRoom.getAllEvents().observe(getViewLifecycleOwner(), eventsFavorites -> favoritesViewModel.getEventsFavoritesAdapter().setData(eventsFavorites));
    }

}
