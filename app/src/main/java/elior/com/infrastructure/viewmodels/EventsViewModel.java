package elior.com.infrastructure.viewmodels;

import static elior.com.infrastructure.retrofit.RetrofitClientInstance.getRetrofitClientInstance;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import elior.com.infrastructure.fragstates.EventsFragState;
import elior.com.infrastructure.models.Events;
import elior.com.infrastructure.others.Constants;
import elior.com.infrastructure.room.EventsFavorites;
import elior.com.infrastructure.room.EventsViewModelFavorites;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsViewModel extends ViewModel {

    private final MutableLiveData<EventsFragState> eventsFragStateMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> text = new MutableLiveData<>();
    private Events events;

    public MutableLiveData<EventsFragState> getEventsFragStateMutableLiveData() {
        return eventsFragStateMutableLiveData;
    }

    public MutableLiveData<String> getText() {
        return text;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        getText().setValue(s.toString());
    }

    public void getAllActivities() {
        getRetrofitClientInstance().getAllActivities("activity").enqueue(new Callback<Events>() {
            @Override
            public void onResponse(@NonNull Call<Events> call, @NonNull Response<Events> response) {
                setEvents(response.body());

                postPositiveResponse(Constants.Events);
            }

            @Override
            public void onFailure(@NonNull Call<Events> call, @NonNull Throwable t) {
                postNegativeResponse(Constants.RESPONSE_ERROR, Constants.API_ERROR);
            }
        });
    }

    public void saveToLocalData() {
        EventsViewModelFavorites eventsViewModelFavorites = new EventsViewModelFavorites();

        EventsFavorites eventsFavorites = new EventsFavorites();

        for (Events events : getDummyData()) {
            eventsFavorites.setActivity(events.getActivity());

            eventsViewModelFavorites.insertEvent(eventsFavorites);
        }
    }

    public ArrayList<Events> getDummyData() {
        ArrayList<Events> eventsArrayList = new ArrayList<>();

//        Events results = new Events();
//        results.setActivity("Elior");
//
        eventsArrayList.add(events);

        return eventsArrayList;
    }

    public void postPositiveResponse(String state) {
        EventsFragState fragState = new EventsFragState();
        fragState.setState(state);
        fragState.setOk(true);
        fragState.setShowWait(false);
        eventsFragStateMutableLiveData.postValue(fragState);
    }

    public void postNegativeResponse(int errorCode, String errorMsg) {
        EventsFragState fragState = new EventsFragState();
        fragState.setState(Constants.API_ERROR);
        fragState.setOk(false);
        fragState.setStateErrorCode(errorCode);
        fragState.setErrorMsg(errorMsg);
        fragState.setShowWait(false);
        eventsFragStateMutableLiveData.postValue(fragState);
    }

}
