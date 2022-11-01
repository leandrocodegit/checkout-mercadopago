package com.api.pay.service;

import com.api.pay.controller.request.TransacaoRequest;
import com.api.pay.model.ml.Pagamento;
import com.api.pay.model.ml.cobranca.CobrancaBoleto;
import com.api.pay.model.ml.cobranca.CobrancaCredito;
import com.api.pay.model.ml.cobranca.CobrancaPix;
import com.api.pay.model.ml.model.TransacaoBuilder;
import com.api.pay.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoComponent {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    public Pagamento criarPagamentoCredito(TransacaoRequest request){
                Pagamento pagamento = new CobrancaCredito().processar().criarCobranca(new TransacaoBuilder()
                .setCard(request.getValor(),request.getNumeroPedido(),request.getParcelas(),request.getToken(), request.getMetodoPagamento())
                .setUsuario(
                        request.getUsuario().getEmail(),
                        request.getUsuario().getNome(),
                        request.getUsuario().getTipoDocumento(),
                        request.getUsuario().getDocumento())
                .builder());
            pagamentoRepository.save(pagamento);
           return pagamento;
    }

    public Pagamento criarPagamentoPix(TransacaoRequest request){
        Pagamento pagamento = new CobrancaPix().processar().criarCobranca(new TransacaoBuilder()
                .setPix(request.getValor(),request.getNumeroPedido())
                .setUsuario(
                        request.getUsuario().getEmail(),
                        request.getUsuario().getNome(),
                        request.getUsuario().getTipoDocumento(),
                        request.getUsuario().getDocumento())
                .builder());
        pagamentoRepository.save(pagamento);
        return pagamento;
    }

    public Pagamento criarPagamentoBoleto(TransacaoRequest request){
        Pagamento pagamento = new CobrancaBoleto().processar().criarCobranca(new TransacaoBuilder()
                .setBoleto(request.getValor(),request.getNumeroPedido())
                .setUsuario(
                        request.getUsuario().getEmail(),
                        request.getUsuario().getNome(),
                        request.getUsuario().getTipoDocumento(),
                        request.getUsuario().getDocumento())
                .setEndereco(
                        request.getUsuario().getEndereco().getCep(),
                        request.getUsuario().getEndereco().getLogradouro(),
                        request.getUsuario().getEndereco().getNumero(),
                        request.getUsuario().getEndereco().getBairro(),
                        request.getUsuario().getEndereco().getCidade(),
                        request.getUsuario().getEndereco().getUf())
                .builder());
        pagamentoRepository.save(pagamento);
        return pagamento;
    }

    public Pagamento buscarPagamento(Long id){
        Pagamento pagamento = new CobrancaCredito().processar().buscarCobranca(id);
        return pagamento;
    }


}
