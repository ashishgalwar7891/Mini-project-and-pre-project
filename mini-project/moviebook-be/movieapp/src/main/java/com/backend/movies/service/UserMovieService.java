package com.backend.movies.service;

import com.backend.movies.model.Movie;
import com.backend.movies.model.User;

import java.util.List;

public interface UserMovieService {
    public abstract User addUser(User user);
    public abstract List<User> getAllUsers();

    public abstract User getUserDetails(String emailId);
    public abstract User addMovie(String email, Movie movie);
    public abstract boolean deleteMovie(String movieId);
}
