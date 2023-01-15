package elior.com.infrastructure.presentation.pages.viewmodels;

import androidx.lifecycle.ViewModel;

import elior.com.infrastructure.presentation.adapters.EventsFavoritesAdapter;

public class FavoritesViewModel extends ViewModel {

    private EventsFavoritesAdapter eventsFavoritesAdapter = new EventsFavoritesAdapter();

    public EventsFavoritesAdapter getEventsFavoritesAdapter() {
        return eventsFavoritesAdapter;
    }

    public void setEventsFavoritesAdapter(EventsFavoritesAdapter eventsFavoritesAdapter) {
        this.eventsFavoritesAdapter = eventsFavoritesAdapter;
    }

}
