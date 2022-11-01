package com.api.pay.controller;

import com.api.pay.controller.request.TransacaoRequest;
import com.api.pay.controller.request.validations.OnAll;
import com.api.pay.controller.request.validations.OnBoleto;
import com.api.pay.controller.request.validations.OnCard;
import com.api.pay.controller.response.PagamentoResponse;
import com.api.pay.mapper.PayMapper;
import com.api.pay.service.PagamentoComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pay")
public class PagamentoController {

    @Autowired
    private PagamentoComponent pagamentoComponent;

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponse> buscarPagamento(@PathVariable Long id) {
        return ResponseEntity.ok(PayMapper.MAPPER.toResponse(
                pagamentoComponent.buscarPagamento(id)));
    }
    @PostMapping("/card")
    public ResponseEntity<PagamentoResponse> processPagamentoCartaoCredito(@RequestBody @Validated({OnAll.class, OnCard.class}) TransacaoRequest request) {
        return ResponseEntity.ok(PayMapper.MAPPER.toResponse(
                pagamentoComponent.criarPagamentoCredito(request)));
    }

    @PostMapping("/pix")
    public ResponseEntity<PagamentoResponse> processPagamentoPix(@RequestBody@Validated(OnAll.class) TransacaoRequest request) {
        return ResponseEntity.ok(PayMapper.MAPPER.toResponse(
                pagamentoComponent.criarPagamentoPix(request)));
    }

    @PostMapping("/boleto")
    public ResponseEntity<PagamentoResponse> processPagamentoBoleto(@RequestBody @Validated(OnBoleto.class) TransacaoRequest request) {
        return ResponseEntity.ok(PayMapper.MAPPER.toResponse(
                pagamentoComponent.criarPagamentoBoleto(request)));
    }


}
