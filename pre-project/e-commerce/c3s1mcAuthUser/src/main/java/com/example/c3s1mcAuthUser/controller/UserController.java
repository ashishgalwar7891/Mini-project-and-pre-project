package com.example.c3s1mcAuthUser.controller;

import com.example.c3s1mcAuthUser.domain.SignUpData;
import com.example.c3s1mcAuthUser.domain.User;
import com.example.c3s1mcAuthUser.exception.UserAlredyExistException;
import com.example.c3s1mcAuthUser.exception.UserNotFoundException;
import com.example.c3s1mcAuthUser.service.SecurityTokengenerator;
import com.example.c3s1mcAuthUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/auth-user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public SecurityTokengenerator securityTokengenerator;

    //http://localhost:6666/api/auth-user/add
    @PostMapping("/add")
    public ResponseEntity<?> addUsers(@RequestBody User user)throws UserAlredyExistException
    {
        try {
            return new ResponseEntity<>(userService.registerUsers(user), HttpStatus.CREATED);
        }
        catch (UserAlredyExistException userAlredyExistException)
        {
            throw userAlredyExistException;
        }

    }
    //http://localhost:6666/api/auth-user/register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignUpData signUpData)throws UserAlredyExistException
    {
        System.out.println("kkkkkk");
        try {
            return new ResponseEntity<>(userService.register1(signUpData), HttpStatus.CREATED);
        }
        catch (UserAlredyExistException userAlredyExistException)
        {
            throw userAlredyExistException;
        }

    }
    //http://localhost:6666/api/auth-user/login
    @PostMapping("/login")
    public ResponseEntity<?> logInuser(@RequestBody User user)throws UserNotFoundException
    {
        try {
            User checkedUser=userService.logInUser(user);
            if(checkedUser!=null)
            {
                return new ResponseEntity<>(securityTokengenerator.generateToken(checkedUser),HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Authonthication Failed....",HttpStatus.NOT_FOUND);
            }
        }
        catch (UserNotFoundException userNotFoundException)
        {
            throw userNotFoundException;
        }

    }
}
