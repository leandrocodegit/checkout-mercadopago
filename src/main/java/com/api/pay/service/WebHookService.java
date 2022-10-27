package com.api.pay.service;

import com.api.pay.controller.request.WebhookRequest;
import com.api.pay.enuns.CodeError;
import com.api.pay.exceptions.EntityResponseException;
import com.api.pay.model.ml.EmbeddedPayment;
import com.api.pay.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebHookService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void atualizarPagamento(WebhookRequest request){
      EmbeddedPayment payment = paymentRepository.findById(request.getData().getId()).orElseThrow(() ->
              new  EntityResponseException("Payment nao localizado", CodeError.PAY_ERROR)
        );
      if (request.getType().equals("payment")){
          if(request.getAction().equals("payment.updated")){

          }
      }
    }
}
