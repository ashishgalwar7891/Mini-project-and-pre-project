package com.example_PE.Login_App.Consumer;

import com.example_PE.Login_App.domain.LoginData;
import com.example_PE.Login_App.services.UserServices;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    private UserServices userServices;

    @RabbitListener(queues = "user_queue1")
    public void listener(LoginData user){
        System.out.println("InSide Mysql consumer MessageListener class :====>"+   user);
        LoginData user1=userServices.addUser(user);
    }
}
