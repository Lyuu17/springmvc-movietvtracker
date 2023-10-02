package com.github.lucx.tvmovietracker.controller;

import com.github.lucx.tvmovietracker.tmdb.TMDBMovieResult;
import com.github.lucx.tvmovietracker.tmdb.TMDBPageResult;
import com.github.lucx.tvmovietracker.tmdb.TMDBService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Query;

import java.io.IOException;

@RestController()
@RequestMapping("api/v1/movie")
public class MovieController {

    @Resource
    private TMDBService tmdbService;

    @GetMapping("/popular")
    public ResponseEntity<?> popularMovies(@Query("language") String language, @Query("page") Integer page) {

        try {
            Call<TMDBPageResult<TMDBMovieResult>> httpCall = tmdbService.popularMovies(language, page);

            Response<TMDBPageResult<TMDBMovieResult>> response = httpCall.execute();

            return ResponseEntity.ok(response.body());
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
