package com.api.pay.service;

import com.api.pay.controller.request.TransacaoRequest;
import com.api.pay.model.ml.Pagamento;
import com.api.pay.repository.PagamentoRepository;
import com.api.pay.rest.RestPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoComponent pagamentoComponent;
    @Autowired
    PagamentoRepository pagamentoRepository;
    @Autowired
    private RestPedido pedido;

    public Pagamento buscarPagamento(Long id){
        if(pagamentoRepository.findById(id).isPresent())
            return pagamentoRepository.findById(id).get();
        else
        return pagamentoComponent.buscarPagamento(id);
    }


}
