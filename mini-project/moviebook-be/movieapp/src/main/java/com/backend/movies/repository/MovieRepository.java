package com.backend.movies.repository;

import com.backend.movies.model.Movie;
//import com.stackroute.product.productapp.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie,String> {
}
