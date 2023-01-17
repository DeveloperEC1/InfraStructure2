package elior.com.infrastructure.presentation.pages.fragments.events_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import elior.com.infrastructure.R;
import elior.com.infrastructure.core.Constants;
import elior.com.infrastructure.data.fragstates.EventsFragState;
import elior.com.infrastructure.databinding.FragmentEventsBinding;
import elior.com.infrastructure.presentation.pages.fragments.BaseFragment;
import elior.com.infrastructure.data.managers.ViewModelManager;

public class EventsFragment extends BaseFragment {

    private FragmentEventsBinding binding;
    private final EventsViewModel eventsViewModel = ViewModelManager.instance.getEventsViewModel();

    private final Observer<EventsFragState> mObserver = eventsFragState -> {
        if (eventsFragState != null) {
            if (!eventsFragState.isHasBeenViewed()) {
                if (eventsFragState.isOk()) {
                    switch (eventsFragState.getState()) {
                        case Constants.EVENTS:

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
        initDataBinding(inflater, container);
        connectObserverToViewModel();
        callGetAllActivitiesEndPoint();

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        removeObserverFromViewModel();
    }

    private void initDataBinding(LayoutInflater inflater, ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_events, container, false);
        binding.setEventsViewModel(eventsViewModel);
        binding.setLifecycleOwner(this);
    }

    private void connectObserverToViewModel() {
        eventsViewModel.getEventsFragStateMutableLiveData().observe(getViewLifecycleOwner(), mObserver);
    }

    private void removeObserverFromViewModel() {
        eventsViewModel.getEventsFragStateMutableLiveData().removeObserver(mObserver);
    }

    private void callGetAllActivitiesEndPoint() {
        showProgressDialog(activity.getResources().getString(R.string.loading_your_data));

        eventsViewModel.getAllActivities();
    }

}
