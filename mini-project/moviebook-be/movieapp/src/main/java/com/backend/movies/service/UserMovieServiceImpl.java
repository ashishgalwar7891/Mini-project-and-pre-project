package com.backend.movies.service;

import com.backend.movies.model.Movie;
import com.backend.movies.model.User;
import com.backend.movies.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMovieServiceImpl implements UserMovieService {

    @Autowired
    private UserMovieRepository userMovieRepository;

    @Override
    public User addUser(User user) {
        return userMovieRepository.insert(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userMovieRepository.findAll();
    }

    @Override
    public User getUserDetails(String emailId) {
        return userMovieRepository.findById(emailId).get();
    }

    @Override
    public User addMovie(String email, Movie movie) {
        User user = userMovieRepository.findById(email).get();
        user.getMovies().add(movie);
        return userMovieRepository.save(user);
    }

    @Override
    public boolean deleteMovie(String movieId) {
        userMovieRepository.deleteById(movieId);
        return true;
    }


}
