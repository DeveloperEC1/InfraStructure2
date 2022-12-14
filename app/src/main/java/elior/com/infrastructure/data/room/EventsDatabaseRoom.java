package elior.com.infrastructure.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {EventsRoom.class}, version = 1, exportSchema = false)
public abstract class EventsDatabaseRoom extends RoomDatabase {

    public abstract EventsDaoRoom eventsDao();

    private static volatile EventsDatabaseRoom INSTANCE;

    public static EventsDatabaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EventsDatabaseRoom.class) {
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(), EventsDatabaseRoom.class, "table_events")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
        }

        return INSTANCE;
    }

}
