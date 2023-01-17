package elior.com.infrastructure.presentation.pages.viewmodels;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import elior.com.infrastructure.data.room.EventsViewModelRoom;

public class ViewModelManager {

    public static final ViewModelManager instance = new ViewModelManager();

    private EventsViewModelRoom eventsViewModelRoom;
    private EventsViewModel eventsViewModel;
    private FavoritesViewModel favoritesViewModel;

    public void initViewModels(FragmentActivity activity) {
        eventsViewModelRoom = new ViewModelProvider(activity).get(EventsViewModelRoom.class);
        eventsViewModel = new ViewModelProvider(activity).get(EventsViewModel.class);
        favoritesViewModel = new ViewModelProvider(activity).get(FavoritesViewModel.class);
    }

    public EventsViewModelRoom getEventsViewModelRoom() {
        return eventsViewModelRoom;
    }

    public void setEventsViewModelRoom(EventsViewModelRoom eventsViewModelRoom) {
        this.eventsViewModelRoom = eventsViewModelRoom;
    }

    public EventsViewModel getEventsViewModel() {
        return eventsViewModel;
    }

    public void setEventsViewModel(EventsViewModel eventsViewModel) {
        this.eventsViewModel = eventsViewModel;
    }

    public FavoritesViewModel getFavoritesViewModel() {
        return favoritesViewModel;
    }

    public void setFavoritesViewModel(FavoritesViewModel favoritesViewModel) {
        this.favoritesViewModel = favoritesViewModel;
    }

}
