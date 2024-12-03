package Movie

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface MovieDao {
    @Upsert
    suspend fun upsertMovieList(movieList: List<MovieEntity>)

    @androidx.room.Query("SELECT * FROM movieentity WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieEntity

    @androidx.room.Query("SELECT * FROM movieentity WHERE category = :category")
    suspend fun getMovieByCategory(category: String): List<MovieEntity>
}