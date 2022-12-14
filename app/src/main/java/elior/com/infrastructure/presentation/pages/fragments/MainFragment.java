package elior.com.infrastructure.presentation.pages.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import elior.com.infrastructure.R;
import elior.com.infrastructure.presentation.adapters.EventsMainAdapter;
import elior.com.infrastructure.databinding.FragmentMainBinding;
import elior.com.infrastructure.data.fragstates.EventsFragState;
import elior.com.infrastructure.core.Constants;
import elior.com.infrastructure.presentation.pages.viewmodels.EventsViewModel;

public class MainFragment extends BaseFragment {

    private FragmentMainBinding binding;
    private final EventsViewModel eventsViewModel = new EventsViewModel();

    private final androidx.lifecycle.Observer<EventsFragState> mObserver = eventsFragState -> {
        if (eventsFragState != null) {
            if (!eventsFragState.isHasBeenViewed()) {
                if (eventsFragState.isOk()) {
                    switch (eventsFragState.getState()) {
                        case Constants.Events:

                            setData();

                            eventsViewModel.saveToLocalData();
                            break;
                    }
                } else {
                    switch (eventsFragState.getStateErrorCode()) {
                        case Constants.RESPONSE_ERROR:

                            Toast.makeText(activity, activity.getResources().getString(R.string.response_error), Toast.LENGTH_LONG).show();
                            break;
                    }
                }

                hideProgressDialog();

                eventsFragState.setHasBeenViewed(true);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.setEventsViewModel(eventsViewModel);
        binding.setLifecycleOwner(this);

        initUI();

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        eventsViewModel.getEventsFragStateMutableLiveData().removeObserver(mObserver);
    }

    private void initUI() {
        eventsViewModel.getEventsFragStateMutableLiveData().observe(getViewLifecycleOwner(), mObserver);

        eventsViewModel.getAllActivities();

        showProgressDialog(activity.getResources().getString(R.string.loading_your_data));
    }

    private void setData() {
        EventsMainAdapter eventsMainAdapter = new EventsMainAdapter(eventsViewModel.getDummyData());
        binding.recyclerView.setAdapter(eventsMainAdapter);
    }
}
