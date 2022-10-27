package com.api.pay.controller;

import com.api.pay.controller.request.CancelRequest;
import com.api.pay.controller.response.EmbeddedPaymentResponse;
import com.api.pay.mapper.PayMapper;
import com.api.pay.model.ml.EmbeddedPayment;
import com.api.pay.rest.RestMercadoPago;
import com.api.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pay")
public class PagamentoController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private RestMercadoPago rest;

    @GetMapping("/{id}")
    public ResponseEntity<EmbeddedPaymentResponse> processPayment(@PathVariable Long id) {
        EmbeddedPayment payment = paymentService.buscaPagamentoId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(PayMapper.MAPPER.toResponse(payment));
    }

    @PutMapping
    public ResponseEntity estornarPayment(@RequestBody CancelRequest request) {
        paymentService.estornarPagamento(request.getId());
        return ResponseEntity.ok().build();
    }
}
