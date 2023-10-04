package com.github.lucx.tvmovietracker.tmdb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("tmdb")
public interface TMDBService {

    @GetMapping("movie/now_playing")
    TMDBPageWithDatesResult<TMDBMovieResult> nowPlaying(@RequestParam("language") String language, @RequestParam("page") int page);

    @GetMapping("movie/popular")
    TMDBPageResult<TMDBMovieResult> popularMovies(@RequestParam("language") String language, @RequestParam("page") int page);

    @GetMapping("movie/top_rated")
    TMDBPageResult<TMDBMovieResult> topRated(@RequestParam("language") String language, @RequestParam("page") int page);
}