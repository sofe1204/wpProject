package com.example.demo.service.ServiceImpl;

import com.example.demo.exceptions.InvalidArgumentsException;
import com.example.demo.model.Movie;
import com.example.demo.model.dto.MovieDto;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return this.movieRepository.findAll();
    }

    @Override
    public List<Movie> listMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findAllByID(Integer id) {
        return this.movieRepository.findAllByID(id);
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return this.movieRepository.findById(id);
    }



    @Override
    public Optional<Movie> save(Integer movie_id, String movie_name,String  movie_age_category,String  movie_cast,String movie_production,String film_director,String movie_time_duration) {
        return Optional.of(this.movieRepository.save(new Movie(movie_id, movie_name, movie_age_category, movie_cast, movie_production,film_director, movie_time_duration)));
    }

    @Override
    public Movie update(Integer movie_id, String movie_name, String movie_age_category, String movie_cast, String movie_production, String film_director, String movie_time_duration) {
        Movie movie = this.movieRepository.findById(movie_id).orElseThrow(InvalidArgumentsException::new);
        movie.setMovie_name(movie_name);
        movie.setMovie_age_category(movie_age_category);
        movie.setMovie_cast(movie_cast);
        movie.setMovie_production(movie_production);
        movie.setMovie_film_director(film_director);
        movie.setMovie_time_duration(movie_time_duration);
        return this.movieRepository.save(movie);

    }

    @Override
    public Optional<Movie> save(MovieDto movieDto) {
        this.movieRepository.deleteById(movieDto.getMovie_id());
        return Optional.of(this.movieRepository.save(new Movie(movieDto.getMovie_id(),movieDto.getMovie_name(), movieDto.getMovie_cast(), movieDto.getMovie_age_category(), movieDto.getMovie_production(),movieDto.getMovie_film_director(), movieDto.getMovie_time_duration())));
    }

    @Override
    public Optional<Movie> findByName(String movie_name) {
        return this.movieRepository.findByName(movie_name);
    }


    @Override
    public Optional<Movie> findAllByName(String s) {
        return this.movieRepository.findAllByName(s);
    }

    @Override
    public void deleteMovieById(Integer id) {
        this.movieRepository.deleteById(id);
    }


}
