package com.backend.movies.repository;//


import com.backend.movies.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMovieRepository extends MongoRepository<User, String> {
    // save() / insert()
    // custom
}
