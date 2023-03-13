package com.example_PE.Registration._App.services;

import com.example_PE.Registration._App.DTO.UserDTO1;
import com.example_PE.Registration._App.domain.SignupData;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    UserDTO1 register1(SignupData signupData);
    List<SignupData> getAllUser();
    Optional<SignupData> findById(String email_Id);
}
