package com.example.c3s1mcAuthUser.service;

import com.example.c3s1mcAuthUser.domain.SignUpData;
import com.example.c3s1mcAuthUser.domain.User;
import com.example.c3s1mcAuthUser.exception.UserAlredyExistException;
import com.example.c3s1mcAuthUser.exception.UserNotFoundException;

public interface UserService {
    public User registerUsers(User user)throws UserAlredyExistException;
    public User logInUser(User user) throws UserNotFoundException;
    public User register1(SignUpData signUpData) throws UserAlredyExistException;
}
