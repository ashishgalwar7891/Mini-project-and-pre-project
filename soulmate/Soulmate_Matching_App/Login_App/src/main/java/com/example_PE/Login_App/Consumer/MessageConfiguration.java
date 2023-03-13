package com.example_PE.Login_App.Consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
    private String exchange_name = "user_exchange1";
    private String register_queue = "user_queue1";
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange(exchange_name);
    }
    @Bean
    public Queue getQueue(){
        return new Queue(register_queue);
    }
    @Bean
    public Jackson2JsonMessageConverter getProducerJacksonConvertor(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public Binding getBinding(Queue queue, TopicExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("routing1");
    }
    public RabbitTemplate getRabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(getProducerJacksonConvertor());
        return rabbitTemplate;
    }
}
