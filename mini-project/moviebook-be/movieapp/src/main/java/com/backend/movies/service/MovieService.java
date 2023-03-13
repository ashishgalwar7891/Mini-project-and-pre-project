package com.backend.movies.service;

import com.backend.movies.model.Movie;

import java.util.List;

public interface MovieService {
    // getallproducts, getproductbyid, addprodct, deleteproduct, updateproduct
    public abstract List<Movie> getAllMovies();
    public abstract Movie addMovie(Movie movie);
    public abstract Movie getMovieById(String movieId);
    public abstract boolean deleteMovie(String movieId);
    public abstract Movie updateMovie(Movie movie);
}
