package com.api.pay.controller;

import com.api.pay.controller.request.WebhookRequest;
import com.api.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/webhook")
public class WebHookController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity notifique(@RequestBody WebhookRequest request){
        paymentService.atualizaPagamento(request.getData().getId());
        return ResponseEntity.ok().build();
    }
}
