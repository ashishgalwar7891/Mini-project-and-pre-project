package com.example_PE.Registration._App.controller;

import com.example_PE.Registration._App.domain.SignupData;
import com.example_PE.Registration._App.repository.UserRepository;
import com.example_PE.Registration._App.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/auth/v1")
public class UserController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;

    // http://localhost:7777/auth/v1/register-user  [POST]
    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody SignupData signupData){
        System.out.println(signupData);
        return new ResponseEntity<>(userServices.register1(signupData),HttpStatus.OK);
    }

    // http://localhost:7777/auth/v1/get-user  [GET]
    @GetMapping("/get-user")
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>(userServices.getAllUser(),HttpStatus.OK);
    }

//    @GetMapping("/getDetailByGender")
//    public ResponseEntity<?> getUserDetailsByGender(){
//        return
//    }

    // http://localhost:7777/auth/v1/findById
    @GetMapping("/findById/{email_Id}")
    public ResponseEntity<?> findById(@RequestBody String email_Id){
        return  new ResponseEntity<>(userRepository.findById(email_Id),HttpStatus.OK);
    }
}
