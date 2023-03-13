package com.example_PE.Registration._App.RabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MessageConfiguration {
    private String exchange_name = "user_exchange1";

    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange(exchange_name);
    }

    @Bean
    public Queue getQueue(){
        return new Queue("user_queue1");
    }
    @Bean
    public Queue getQueue2(){
        return new Queue("user_queue2");
    }
    @Bean
    public Jackson2JsonMessageConverter getProducerJacksonConvertor(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding getBinding(Queue getQueue, TopicExchange directExchange){
        return BindingBuilder.bind(getQueue).to(directExchange).with("routing1");
    }
    @Bean
    public Binding getBinding2(Queue getQueue2, TopicExchange directExchange){
        return BindingBuilder.bind(getQueue2).to(directExchange).with("routing2");
    }
    public RabbitTemplate getRabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        System.out.println(rabbitTemplate);
        rabbitTemplate.setMessageConverter(getProducerJacksonConvertor());
        return rabbitTemplate;
    }
}
