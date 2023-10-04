package com.github.lucx.tvmovietracker.tmdb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("tmdb")
public interface TMDBService {

    /**
     * MOVIE LISTS
     */

    @GetMapping("movie/now_playing")
    TMDBPageWithDatesResult<TMDBMovieResult> movieNowPlaying(@RequestParam Map<String, String> options);

    @GetMapping("movie/popular")
    TMDBPageResult<TMDBMovieResult> moviePopular(@RequestParam Map<String, String> options);

    @GetMapping("movie/top_rated")
    TMDBPageResult<TMDBMovieResult> movieTopRated(@RequestParam Map<String, String> options);

    @GetMapping("movie/upcoming")
    TMDBPageResult<TMDBMovieResult> movieUpcoming(@RequestParam Map<String, String> options);

    /**
     * MOVIES
     */

    @GetMapping("movie/{id}")
    TMDBMovieDetailsResult movieDetails(@PathVariable("id") int id);

    /**
     * SEARCH
     */

    @GetMapping("search/movie")
    TMDBPageResult<TMDBMovieResult> movieSearch(@RequestParam("query") String query,
                                                @RequestParam Map<String, String> options);
}