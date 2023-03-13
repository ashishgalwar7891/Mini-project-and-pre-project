package com.example.soulmatematchingservice.Consumer;

import com.example.soulmatematchingservice.domain.User;
import com.example.soulmatematchingservice.services.UserServices;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    private UserServices userServices;

    @RabbitListener(queues = "user_queue2")
    public void listener(User user){
        System.out.println("InSide Neo4j consumer MessageListener class :====>"+   user);
        try {
            User user1 = userServices.saveUser(user);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
