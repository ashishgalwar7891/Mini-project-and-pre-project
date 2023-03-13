package com.example_PE.Registration._App.RabbitMQ;

import com.example_PE.Registration._App.DTO.UserDTO2;
import com.example_PE.Registration._App.DTO.UserDTO3;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private TopicExchange directExchange;

    public void sendUserDtoToQueue1(UserDTO2 user)
    {
        System.out.println("sendUserDtoToQueue1----->  "+user);
        rabbitTemplate.convertAndSend(directExchange.getName(),"routing1",user);
    }
    public void sendUserDtoToQueue2(UserDTO3 user)
    {
        System.out.println("sendUserDtoToQueue2----->  "+user);
        rabbitTemplate.convertAndSend(directExchange.getName(),"routing2",user);
    }
}
