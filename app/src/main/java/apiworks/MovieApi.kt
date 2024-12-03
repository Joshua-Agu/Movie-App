package apiworks

import respond.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{category}")
    suspend fun getMovieList(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apikey: String = API_KEY
    ) : MovieListDto

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://api.themoviedb.org/t/p/w500/"
        const val MOVIE_GENRE_URL = "https://api.themoviedb.org/3/genre/movie/list?language=en"
        const val API_KEY = "e023df50ae4799716c65c4c743342cb1"


    }
}