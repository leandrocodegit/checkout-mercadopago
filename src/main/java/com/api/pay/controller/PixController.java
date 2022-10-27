package com.api.pay.controller;

import com.api.pay.controller.request.PaymentRequest;
import com.api.pay.controller.response.EmbeddedPaymentPIXResponse;
import com.api.pay.controller.response.EmbeddedPaymentResponse;
import com.api.pay.controller.response.QRCodeResponse;
import com.api.pay.valid.OnPedido;
import com.api.pay.valid.OnPix;
import com.api.pay.mapper.PayMapper;
import com.api.pay.model.ml.EmbeddedPayment;
import com.api.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pay/pix")
public class PixController {

    @Autowired
    public PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<EmbeddedPaymentPIXResponse> buscaPagamentoPIX(@PathVariable Long id) {
        EmbeddedPayment payment = paymentService.buscaPagamentoId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(PayMapper.MAPPER.toPIXResponse(payment));
    }

    @GetMapping("/qrcode/id/{id}")
    public  ResponseEntity<QRCodeResponse> viewQRcode(@PathVariable Long id) {
        EmbeddedPayment payment = paymentService.buscaPagamentoId(id);
        return ResponseEntity.ok(new QRCodeResponse(payment.getPointOfInteraction().getTransactionData().getQrCodeBase64()));
    }

    @GetMapping("/create/{pedido}")
    public ResponseEntity<EmbeddedPaymentResponse> criaPagamentoPixComPedido(@PathVariable String pedido) {
        System.err.println("Pedido " + pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(PayMapper.MAPPER.toResponse(paymentService.criarPaymentPix(pedido)));
    }

    @GetMapping("/cancel/{id}/{notifique}")
    public ResponseEntity<EmbeddedPaymentResponse> cancelarPagamentoPix(@PathVariable Long id, @PathVariable boolean notifique) {
        System.out.println("Cancelando pix " + id);
        return ResponseEntity.status(HttpStatus.CREATED).body(PayMapper.MAPPER.toResponse(paymentService.cancelarPix(id, notifique)));
    }






}
