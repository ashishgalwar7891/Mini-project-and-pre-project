package com.example_PE.Registration._App.services;


import com.example_PE.Registration._App.DTO.UserDTO1;
import com.example_PE.Registration._App.DTO.UserDTO2;
import com.example_PE.Registration._App.DTO.UserDTO3;
import com.example_PE.Registration._App.RabbitMQ.UserDetailsProducer;
import com.example_PE.Registration._App.domain.SignupData;

import com.example_PE.Registration._App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsProducer userDetailsProducer;

    @Override
    public UserDTO1 register1(SignupData signupData) {
        UserDTO1 userDTO=new UserDTO1(signupData.getEmail_Id(),signupData.getName(),signupData.getAge(),signupData.getGender(),signupData.getCity(),signupData.getImgURL());
        UserDTO1 user1= userRepository.insert(userDTO);
        System.out.println(user1);

        UserDTO2 user2=new UserDTO2(signupData.getEmail_Id(),signupData.getPassword(),signupData.getGender());
        userDetailsProducer.sendUserDtoToQueue1(user2);
        System.out.println(user2);

        UserDTO3 user3=new UserDTO3(signupData.getEmail_Id(),signupData.getName(),signupData.getAge(),signupData.getGender(),signupData.getCity());
        userDetailsProducer.sendUserDtoToQueue2(user3);
        System.out.println(user3);

        return user1;
    }

    @Override
    public List<SignupData> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<SignupData> findById(String email_Id) {
        return userRepository.findById(email_Id);
    }

}
