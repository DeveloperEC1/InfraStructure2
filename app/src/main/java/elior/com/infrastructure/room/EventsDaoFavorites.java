package elior.com.infrastructure.room;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface EventsDaoFavorites {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EventsFavorites eventsFavorites);

    @Update
    void update(EventsFavorites... eventsFavorites);

    @Delete
    void delete(EventsFavorites eventsFavorites);

    @Query("DELETE FROM table_events")
    void deleteAll();

    @Query("SELECT * from table_events ORDER BY activity ASC")
    LiveData<List<EventsFavorites>> getAllEvents();

}
