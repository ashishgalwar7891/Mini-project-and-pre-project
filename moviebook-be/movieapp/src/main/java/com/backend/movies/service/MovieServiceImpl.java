package com.backend.movies.service;

import com.backend.movies.model.Movie;
import com.backend.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.insert(movie);
    }
    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).get();
    }
    @Override
    public boolean deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
        return true;
    }
    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
