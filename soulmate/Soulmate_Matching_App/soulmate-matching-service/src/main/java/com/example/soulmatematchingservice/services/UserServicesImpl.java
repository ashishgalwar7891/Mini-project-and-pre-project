package com.example.soulmatematchingservice.services;

import com.example.soulmatematchingservice.DTO.Interested;
import com.example.soulmatematchingservice.domain.User;

import com.example.soulmatematchingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServicesImpl implements UserServices{

    private UserRepository userRepository;

    @Autowired
    public void UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public List<Map<String, Interested>> getInterested(String email) {
        System.out.println("CCCCCCCCCCCCCCC  "+email);
        System.out.println("BBBBBBBBBBBBBBBB   "+userRepository.getLiked(email));
        return userRepository.getLiked(email);
    }

    @Override
    public String liked(String user1, String user2) {
        System.out.println(user1);
        System.out.println(user2);
        userRepository.addInterest(user1, user2);
        return "Liked";
    }

}
