package com.example_PE.Login_App.controller;

import com.example_PE.Login_App.ToKen.SecurityTokenGenerator;
import com.example_PE.Login_App.domain.LoginData;
import com.example_PE.Login_App.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/v2")
public class UserController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    // http://localhost:3333/auth/v2/login-check  [POST]
    @PostMapping("/login-check")
    public ResponseEntity<?> loginCheck(@RequestBody LoginData user){
        boolean result= userServices.loginCheck(user);
        if(result){
            return new ResponseEntity<>(securityTokenGenerator.generateToken(user),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Authentication failed", HttpStatus.OK);
        }
    }

}
