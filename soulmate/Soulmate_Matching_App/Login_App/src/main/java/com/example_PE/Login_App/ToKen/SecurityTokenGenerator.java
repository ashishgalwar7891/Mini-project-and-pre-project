package com.example_PE.Login_App.ToKen;

import com.example_PE.Login_App.domain.LoginData;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(LoginData user);
}
