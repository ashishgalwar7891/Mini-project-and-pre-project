package com.backend.movies.controller;

import com.backend.movies.model.Movie;
import com.backend.movies.model.User;
import com.backend.movies.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/movie-app-v1")
public class UserMovieController {

    @Autowired
    private UserMovieService userMovieService;

    // http://localhost:5555/product-app-v1/add-user  [POST]
    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody User user){
        user.setMovies(new ArrayList<Movie>());
        return new ResponseEntity(userMovieService.addUser(user), HttpStatus.OK);
    }

    // http://localhost:5555/product-app-v1/get-user-details  [GET]
    @GetMapping("/get-user-details")
    public ResponseEntity<?> getUserDetails(HttpServletRequest request){
        String emailid = (String) request.getAttribute("current_user_emailid");
        return new ResponseEntity<>(userMovieService.getUserDetails(emailid),HttpStatus.OK);
    }

    // http://localhost:5555/product-app-v1/add-product-to-user  [POST]
    @PostMapping("/add-movie-to-user")
    public ResponseEntity<?> addProduct(@RequestBody Movie movie, HttpServletRequest request){
        String current_email= (String) request.getAttribute("current_user_emailid");
        return new ResponseEntity<>(userMovieService.addMovie(current_email,movie),HttpStatus.OK);
    }
    @DeleteMapping("/delete-movie-to-user/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable String movieId){
        return new ResponseEntity<>(userMovieService.deleteMovie(movieId),HttpStatus.GONE);
    }

}







/*


 */