package com.github.lucx.tvmovietracker.tmdb;

import lombok.Data;

import java.util.List;

@Data
public class TMDBMovieResult {

    Boolean adult;

    String backdrop_path;

    List<Integer> genre_ids;

    Integer id;

    String original_language;

    String original_title;

    String overview;

    Float popularity;

    String poster_path;

    String release_date;

    String title;

    Boolean video;

    Float vote_average;

    Integer vote_count;
}
