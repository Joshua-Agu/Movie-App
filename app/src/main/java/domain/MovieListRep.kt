package domain

import domain.model.Movie
import kotlinx.coroutines.flow.Flow
import utility.Resource

interface MovieListRep {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int,
    ) : Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int): Flow<Resource<Movie>>
}