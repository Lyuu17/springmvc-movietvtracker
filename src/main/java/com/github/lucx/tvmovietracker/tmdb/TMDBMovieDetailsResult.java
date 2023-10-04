package com.github.lucx.tvmovietracker.tmdb;

import lombok.Data;

import java.util.List;

@Data
public class TMDBMovieDetailsResult {

    Boolean adult;

    String backdrop_path;

    String belongs_to_collection;

    Integer budget;

    List<TMDBGenreResult> genres;

    String homepage;

    Integer id;

    String imdb_id;

    String original_language;

    String original_title;

    String overview;

    Float popularity;

    String poster_path;

    List<TMDBProductionCompanyResult> production_companies;

    List<TMDBProductionCountryResult> production_countries;

    String release_date;

    Integer revenue;

    Integer runtime;

    List<TMDBSpokenLanguageResult> spoken_languages;

    String status;

    String tagline;

    String title;

    Boolean video;

    Float vote_average;

    Integer vote_count;
}
