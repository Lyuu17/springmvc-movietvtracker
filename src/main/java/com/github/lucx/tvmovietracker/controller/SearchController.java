package com.github.lucx.tvmovietracker.controller;

import com.github.lucx.tvmovietracker.tmdb.TMDBMovieResult;
import com.github.lucx.tvmovietracker.tmdb.TMDBPageResult;
import com.github.lucx.tvmovietracker.tmdb.TMDBService;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("api/v1/search")
public class SearchController {

    @Resource
    private TMDBService tmdbService;

    @GetMapping("/movie")
    @Cacheable("movieSearch")
    public ResponseEntity<?> movieSearch(@RequestParam("query") String query,
                                         @RequestParam("include_adult") Optional<Boolean> includeAdult,
                                         @RequestParam("language") Optional<String> language,
                                         @RequestParam("primary_release_year") Optional<String> primaryReleaseYear,
                                         @RequestParam("page") Optional<Integer> page,
                                         @RequestParam("region") Optional<String> region,
                                         @RequestParam("year") Optional<String> year) {

        try {
            Map<String, String> options = new HashMap<>();

            includeAdult.ifPresent((v) -> options.put("include_adult", v.toString()));
            language.ifPresent((v) -> options.put("language", v));
            primaryReleaseYear.ifPresent((v) -> options.put("primary_release_year", v));
            page.ifPresent((v) -> options.put("page", v.toString()));
            region.ifPresent((v) -> options.put("region", v));
            year.ifPresent((v) -> options.put("year", v));
            
            TMDBPageResult<TMDBMovieResult> pageResult = tmdbService.movieSearch(query, options);

            return ResponseEntity.ok(pageResult);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
