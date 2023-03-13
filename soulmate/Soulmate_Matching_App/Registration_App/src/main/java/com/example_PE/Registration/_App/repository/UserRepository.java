package com.example_PE.Registration._App.repository;

import com.example_PE.Registration._App.DTO.UserDTO1;
import com.example_PE.Registration._App.domain.SignupData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<SignupData,String> {

    UserDTO1 insert(UserDTO1 userDTO1);



}
