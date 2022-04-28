package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.model.dto.MovieDto;


import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAll();
    List<Movie> listMovies();
    Optional<Movie> findAllByID(Integer id);
    Optional<Movie> findById(Integer id);

    Optional<Movie> save(Integer movie_id, String movie_name,String  movie_age_category,String  movie_cast,String movie_production,String film_director,String movie_time_duration);
    Movie update(Integer movie_id, String movie_name, String  movie_age_category, String  movie_cast, String movie_production, String film_director, String movie_time_duration);

    Optional<Movie> save(MovieDto movieDto);

    Optional<Movie> findByName(String movie_name);
    Optional<Movie> findAllByName(String s);

    void deleteMovieById(Integer id);
}
