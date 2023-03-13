package com.backend.authapp.rabbitmq;

//@Component
public class MailProducer {
//    @Autowired
 //   private RabbitTemplate rabbitTemplate;
 //   @Autowired
  //  private DirectExchange directExchange;

    public void sendMailDtoToQueue(EmailDTO emailDTO){
       // rabbitTemplate.convertAndSend(directExchange.getName(),"mail_routing",emailDTO);
    }
}


// @Bean