package com.api.pay.rest;

import com.api.pay.model.ml.EmbeddedPayment;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "mercadoPago",
        url = "${integration.ml.url}"
)
public interface RestMercadoPago {

    String AUTH_TOKEN = "Authorization";

    @GetMapping("/payments/{id}")
    @Headers("Content-Type: application/json")
    public EmbeddedPayment findPayment(@PathVariable Long id);
    @PutMapping("/payments/{id}")
    public EmbeddedPayment cancelPayment(@PathVariable Long id);
}
