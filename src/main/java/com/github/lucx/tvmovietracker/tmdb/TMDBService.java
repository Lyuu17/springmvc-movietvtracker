package com.github.lucx.tvmovietracker.tmdb;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBService {

    @GET("movie/popular")
    Call<TMDBPageResult<TMDBMovieResult>> popularMovies(@Query("language") String language, @Query("page") int page);
}