package elior.com.infrastructure.data.room;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface EventsDaoRoom {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EventsRoom eventsFavorites);

    @Update
    void update(EventsRoom... eventsFavorites);

    @Delete
    void delete(EventsRoom eventsFavorites);

    @Query("DELETE FROM table_events")
    void deleteAll();

    @Query("SELECT * from table_events ORDER BY activity ASC")
    LiveData<List<EventsRoom>> getAllEvents();

}
