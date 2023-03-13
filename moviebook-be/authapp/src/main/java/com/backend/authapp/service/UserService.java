package com.backend.authapp.service;

import com.backend.authapp.model.User;
import com.backend.authapp.model.SignupData;

public interface UserService {
    public abstract User registerUser1(SignupData signupData);
    public abstract User registerUser(User user);
    public abstract User loginCheck(User user);
}



