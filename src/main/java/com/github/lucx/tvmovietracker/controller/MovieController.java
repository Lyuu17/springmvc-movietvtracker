package com.github.lucx.tvmovietracker.controller;

import com.github.lucx.tvmovietracker.tmdb.*;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("api/v1/movie")
public class MovieController {

    @Resource
    private TMDBService tmdbService;

    @GetMapping("/now_playing")
    @Cacheable("nowPlaying")
    public ResponseEntity<?> nowPlaying(@RequestParam("language") Optional<String> language,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("region") Optional<String> region) {

        Map<String, String> options = new HashMap<>();

        language.ifPresent((v) -> options.put("language", v));
        page.ifPresent((v) -> options.put("page", v.toString()));
        region.ifPresent((v) -> options.put("region", v));

        try {
            TMDBPageWithDatesResult<TMDBMovieResult> pageWithDatesResult = tmdbService.movieNowPlaying(options);

            return ResponseEntity.ok(pageWithDatesResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/popular")
    @Cacheable("popular")
    public ResponseEntity<?> popular(@RequestParam("language") Optional<String> language,
                                     @RequestParam("page") Optional<Integer> page,
                                     @RequestParam("region") Optional<String> region) {

        Map<String, String> options = new HashMap<>();

        language.ifPresent((v) -> options.put("language", v));
        page.ifPresent((v) -> options.put("page", v.toString()));
        region.ifPresent((v) -> options.put("region", v));

        try {
            TMDBPageResult<TMDBMovieResult> pageResult = tmdbService.moviePopular(options);

            return ResponseEntity.ok(pageResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/top_rated")
    @Cacheable("topRated")
    public ResponseEntity<?> topRated(@RequestParam("language") Optional<String> language,
                                      @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("region") Optional<String> region) {

        Map<String, String> options = new HashMap<>();

        language.ifPresent((v) -> options.put("language", v));
        page.ifPresent((v) -> options.put("page", v.toString()));
        region.ifPresent((v) -> options.put("region", v));

        try {
            TMDBPageResult<TMDBMovieResult> pageResult = tmdbService.movieTopRated(options);

            return ResponseEntity.ok(pageResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/upcoming")
    @Cacheable("upcoming")
    public ResponseEntity<?> upcoming(@RequestParam("language") Optional<String> language,
                                      @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("region") Optional<String> region) {

        Map<String, String> options = new HashMap<>();

        language.ifPresent((v) -> options.put("language", v));
        page.ifPresent((v) -> options.put("page", v.toString()));
        region.ifPresent((v) -> options.put("region", v));

        try {
            TMDBPageResult<TMDBMovieResult> pageResult = tmdbService.movieUpcoming(options);

            return ResponseEntity.ok(pageResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Cacheable("details")
    public ResponseEntity<?> details(@PathVariable("id") Integer id) {

        try {
            TMDBMovieDetailsResult result = tmdbService.movieDetails(id);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
