package elior.com.infrastructure.room;

import static elior.com.infrastructure.others.MyApplication.getApplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class EventsViewModelFavorites extends ViewModel {

    private final EventsDaoFavorites eventsDaoFavorites = EventsRoomDatabaseFavorites.getDatabase(getApplication()).eventsDao();

    public void insertEvent(EventsFavorites eventsFavorites) {
        eventsDaoFavorites.insert(eventsFavorites);
    }

    public void updateEvent(EventsFavorites eventsFavorites) {
        eventsDaoFavorites.update(eventsFavorites);
    }

    public void deleteEvent(EventsFavorites eventsFavorites) {
        eventsDaoFavorites.delete(eventsFavorites);
    }

    public void deleteAllEvents() {
        eventsDaoFavorites.deleteAll();
    }

    public LiveData<List<EventsFavorites>> getAllEvents() {
        return eventsDaoFavorites.getAllEvents();
    }

}
