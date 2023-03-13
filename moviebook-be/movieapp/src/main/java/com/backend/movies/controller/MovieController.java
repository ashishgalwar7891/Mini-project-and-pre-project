package com.backend.movies.controller;

import com.backend.movies.model.Movie;
import com.backend.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie-app-v1")
public class MovieController {
    @Autowired
    private MovieService movieService;
    /*
    GET
    http://localhost:5555/product-app-v1/get-all-products
     */
    @GetMapping("/get-all-movies")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }
    /*
 GET
 http://localhost:5555/product-app-v1/get-product-by-id/XXXXX
  */
    @GetMapping("/get-movie-by-id/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable String movieId){
        return new ResponseEntity<>(movieService.getMovieById(movieId),HttpStatus.OK);
    }

    /*
 POST
 http://localhost:5555/product-app-v1/admin/add-new-product
  */
    @PostMapping("/admin/add-new-movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){

        return new ResponseEntity<>(movieService.addMovie(movie),HttpStatus.OK);
    }

    /*
 PUT
 http://localhost:5555/product-app-v1/admin/update-product
  */
    @PutMapping("/admin/update-movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie moviet){
        return new ResponseEntity<>(movieService.updateMovie(moviet),HttpStatus.OK);
    }

    /*
 DELETE
 http://localhost:5555/product-app-v1/admin/delete-product/XXXXX
  */
    @DeleteMapping("/admin/delete-movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable String movieId){
        return new ResponseEntity<>(movieService.deleteMovie(movieId),HttpStatus.OK);
    }
}
