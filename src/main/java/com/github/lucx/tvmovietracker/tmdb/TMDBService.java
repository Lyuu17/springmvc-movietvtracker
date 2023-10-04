package com.github.lucx.tvmovietracker.tmdb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("tmdb")
public interface TMDBService {

    /**
     * MOVIE DETAILS
     */

    @GetMapping("movie/now_playing")
    TMDBPageWithDatesResult<TMDBMovieResult> movieNowPlaying(@RequestParam("language") String language, @RequestParam("page") int page);

    @GetMapping("movie/popular")
    TMDBPageResult<TMDBMovieResult> moviePopular(@RequestParam("language") String language, @RequestParam("page") int page);

    @GetMapping("movie/top_rated")
    TMDBPageResult<TMDBMovieResult> movieTopRated(@RequestParam("language") String language, @RequestParam("page") int page);

    @GetMapping("movie/upcoming")
    TMDBPageResult<TMDBMovieResult> movieUpcoming(@RequestParam("language") String language, @RequestParam("page") int page);

    /**
     * MOVIES
     */

    @GetMapping("movie/{id}")
    TMDBMovieDetailsResult movieDetails(@PathVariable("id") int id);
}