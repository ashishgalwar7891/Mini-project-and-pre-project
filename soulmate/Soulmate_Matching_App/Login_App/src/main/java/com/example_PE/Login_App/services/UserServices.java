package com.example_PE.Login_App.services;

import com.example_PE.Login_App.domain.LoginData;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    boolean loginCheck(LoginData user);
    LoginData addUser(LoginData user);

}
