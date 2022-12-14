package elior.com.infrastructure.data.room;

import static elior.com.infrastructure.core.MyApplication.getApplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class EventsViewModelRoom extends ViewModel {

    private final EventsDaoRoom eventsDaoFavorites = EventsDatabaseRoom.getDatabase(getApplication()).eventsDao();

    public void insertEvent(EventsRoom eventsFavorites) {
        eventsDaoFavorites.insert(eventsFavorites);
    }

    public void updateEvent(EventsRoom eventsFavorites) {
        eventsDaoFavorites.update(eventsFavorites);
    }

    public void deleteEvent(EventsRoom eventsFavorites) {
        eventsDaoFavorites.delete(eventsFavorites);
    }

    public void deleteAllEvents() {
        eventsDaoFavorites.deleteAll();
    }

    public LiveData<List<EventsRoom>> getAllEvents() {
        return eventsDaoFavorites.getAllEvents();
    }

}
