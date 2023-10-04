package com.github.lucx.tvmovietracker.controller;

import com.github.lucx.tvmovietracker.tmdb.TMDBMovieResult;
import com.github.lucx.tvmovietracker.tmdb.TMDBPageResult;
import com.github.lucx.tvmovietracker.tmdb.TMDBPageWithDatesResult;
import com.github.lucx.tvmovietracker.tmdb.TMDBService;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/v1/movie")
public class MovieController {

    @Resource
    private TMDBService tmdbService;

    @GetMapping("/now_playing")
    @Cacheable("nowPlaying")
    public ResponseEntity<?> nowPlaying(@RequestParam("language") String language, @RequestParam("page") Integer page) {

        try {
            TMDBPageWithDatesResult<TMDBMovieResult> pageWithDatesResult = tmdbService.nowPlaying(language, page);

            return ResponseEntity.ok(pageWithDatesResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/popular")
    @Cacheable("popularMovies")
    public ResponseEntity<?> popularMovies(@RequestParam("language") String language, @RequestParam("page") Integer page) {

        try {
            TMDBPageResult<TMDBMovieResult> pageResult = tmdbService.popularMovies(language, page);

            return ResponseEntity.ok(pageResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/top_rated")
    @Cacheable("topRated")
    public ResponseEntity<?> topRated(@RequestParam("language") String language, @RequestParam("page") Integer page) {

        try {
            TMDBPageResult<TMDBMovieResult> pageResult = tmdbService.topRated(language, page);

            return ResponseEntity.ok(pageResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
