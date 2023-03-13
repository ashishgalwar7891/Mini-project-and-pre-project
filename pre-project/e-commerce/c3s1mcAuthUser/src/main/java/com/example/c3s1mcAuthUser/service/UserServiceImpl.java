package com.example.c3s1mcAuthUser.service;

import com.example.c3s1mcAuthUser.Proxy.UserProxy;
import com.example.c3s1mcAuthUser.domain.SignUpData;
import com.example.c3s1mcAuthUser.domain.User;
import com.example.c3s1mcAuthUser.domain.UserDto;
import com.example.c3s1mcAuthUser.exception.UserAlredyExistException;
import com.example.c3s1mcAuthUser.exception.UserNotFoundException;
import com.example.c3s1mcAuthUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    private UserProxy userProxy;


    @Autowired
    public UserServiceImpl(UserProxy userProxy) {
        this.userProxy = userProxy;
    }



    @Override
    public User register1(SignUpData signUpData) throws UserAlredyExistException {
        UserDto userDTO=new UserDto(signUpData.getUserName(),signUpData.getEmail(),signUpData.getMobileNo(),signUpData.getAddress());
        ResponseEntity<?> responseEntity=userProxy.sendDataToProductApp(userDTO);

        User user=new User(signUpData.getEmail(),signUpData.getPassword());
        return userRepository.save(user);
    }


    @Override
    public User registerUsers(User user) throws UserAlredyExistException {
       if(userRepository.findById(user.getEmail()).isEmpty())
       {
         return userRepository.save(user);
       }
     else {
         throw new UserAlredyExistException();
       }
    }



    @Override
    public User logInUser(User user) throws UserNotFoundException {
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            User user1=userRepository.findById(user.getEmail()).get();
            if(user1.getPassword().equals(user.getPassword()))
            {
                return user1;
            }
            else {
                return null;
            }
        }
        else {
            throw new UserNotFoundException();
        }
    }
}
