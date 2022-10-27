package com.api.pay.service;

import com.api.pay.publish.MensagemSend;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendRabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendRabbitMQ(MensagemSend mensagem){
        rabbitTemplate.convertAndSend("QUEUE_NOTIFICACAO-PAYMENT",
                "",
                mensagem);
    }


}
