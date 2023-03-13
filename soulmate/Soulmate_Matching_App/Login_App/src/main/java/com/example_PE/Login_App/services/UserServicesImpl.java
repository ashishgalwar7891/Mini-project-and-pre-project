package com.example_PE.Login_App.services;

import com.example_PE.Login_App.domain.LoginData;
import com.example_PE.Login_App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices
{
    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    @Override
    public LoginData addUser(LoginData user) {
        System.out.println("in side services"+user);
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        return userRepository.save(user);
    }

    @Override
    public boolean loginCheck(LoginData user) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

        LoginData l1 = userRepository.findById(user.getEmail_Id()).get();
        if(l1!=null) {
            boolean match = passwordEncoder.matches(user.getPassword(), l1.getPassword());
            return match;
        }
        return false;
    }
}

