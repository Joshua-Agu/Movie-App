package Movie

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class movieDatabase: RoomDatabase(){
    abstract val movieDao: MovieDao
}