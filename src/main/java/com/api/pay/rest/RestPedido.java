package com.api.pay.rest;

import com.api.pay.rest.fallbacks.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
        name = "pedido",
        url = "${integration.pedido.url}",
        fallback = Pedido.class
)
public interface RestPedido {

    @GetMapping("/valid/{id}")
    public boolean pedidoIsValido(@PathVariable String id);
    @GetMapping("/{id}")
    public Pedido buscaPedido(@PathVariable String id);


}
