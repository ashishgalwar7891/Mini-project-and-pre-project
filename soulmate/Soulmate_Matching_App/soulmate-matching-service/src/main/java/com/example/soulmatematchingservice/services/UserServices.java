package com.example.soulmatematchingservice.services;

import com.example.soulmatematchingservice.DTO.Interested;
import com.example.soulmatematchingservice.domain.User;

import java.util.List;
import java.util.Map;

public interface UserServices {

    User saveUser(User user);

    List<User> getUser();

    List<Map<String, Interested>> getInterested(String email);

    String liked(String user1, String user2);

}
