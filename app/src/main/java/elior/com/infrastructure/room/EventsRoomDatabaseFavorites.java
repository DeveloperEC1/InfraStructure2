package elior.com.infrastructure.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {EventsFavorites.class}, version = 1, exportSchema = false)
//@TypeConverters(Converter.class)
public abstract class EventsRoomDatabaseFavorites extends RoomDatabase {

    public abstract EventsDaoFavorites eventsDao();

    private static volatile EventsRoomDatabaseFavorites INSTANCE;

    public static EventsRoomDatabaseFavorites getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EventsRoomDatabaseFavorites.class) {
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(), EventsRoomDatabaseFavorites.class, "table_events")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }

        return INSTANCE;
    }

}
