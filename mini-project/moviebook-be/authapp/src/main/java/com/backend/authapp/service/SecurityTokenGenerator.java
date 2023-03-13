package com.backend.authapp.service;

import com.backend.authapp.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(User user);
}
