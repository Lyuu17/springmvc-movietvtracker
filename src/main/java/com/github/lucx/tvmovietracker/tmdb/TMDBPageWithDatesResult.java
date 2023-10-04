package com.github.lucx.tvmovietracker.tmdb;

import lombok.Data;

import java.util.List;

@Data
public class TMDBPageWithDatesResult<T> {

    TMDBDatesResult dates;

    Integer page;

    List<T> results;

    Integer total_pages;

    Integer total_results;
}
