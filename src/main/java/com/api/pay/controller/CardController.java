package com.api.pay.controller;

import com.api.pay.controller.request.PaymentRequest;
import com.api.pay.controller.response.PaymentResponse;
import com.api.pay.valid.OnCard;
import com.api.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pay/card") 
public class CardController {

    @Autowired
    public PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody @Validated({OnCard.class}) PaymentRequest request) {
        PaymentResponse payment = paymentService.processCardPayment(request);
        payment.setNumeroPedido(request.getNumeroPedido());
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }



}
