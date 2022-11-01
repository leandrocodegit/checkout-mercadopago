package com.api.pay.model.ml.model;

import com.api.pay.model.ml.Pagamento;
import com.api.pay.model.ml.Transacao;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PagamentoBuild {

    private Pagamento instance;


    public PagamentoBuild create(Long id, String metodoPagamento, String status, String detalhes, BigDecimal valor) {
        this.instance = new Pagamento(id, metodoPagamento, status, detalhes, valor);
        return this;
    }

    public PagamentoBuild setDatesTime(OffsetDateTime dataCriacao, OffsetDateTime dataAprovacao,OffsetDateTime ultimaAtualizacao){
        instance.setDataAprovacao(dataAprovacao);
        instance.setDataCriacao(dataCriacao);
        instance.setUltimaAtualizacao(ultimaAtualizacao);
        return this;
    }

    public PagamentoBuild setEstorno(OffsetDateTime dataCriacao){
        instance.setDataEstorno(dataCriacao);
        return this;
    }

    public PagamentoBuild setCardDetalhes(String ultimosDigitosCartao, String issuer, BigDecimal valorParcela, BigDecimal total, int parcelas){
        instance.setQuatroDigitosCartao(ultimosDigitosCartao);
        instance.setIssuerId(issuer);
        instance.setValorParcela(valorParcela);
        instance.setParcelas(parcelas);
        instance.setTotal(total);
        return this;
    }

    public PagamentoBuild setTransacao(Transacao transacao){
        instance.setTransacao(transacao);
        return this;
    }

    public PagamentoBuild setPixDetalhes(String qrcode, String qrcode64, OffsetDateTime dataExpiracao){
        instance.setQrCode(qrcode);
        instance.setQrCodeBase64(qrcode64);
        instance.setDataExpiracao(dataExpiracao);
        instance.setParcelas(1);
        return this;
    }

    public PagamentoBuild setBoletoDetalhes(String url, String codigoBarras, BigDecimal total, OffsetDateTime dataExpiracao){
        instance.setUrl(url);
        instance.setDataExpiracao(dataExpiracao);
        instance.setBarcode(codigoBarras);
        instance.setTotal(total);
        instance.setParcelas(1);
        return this;
    }

    public Pagamento build(){
        return instance;
    }

}
