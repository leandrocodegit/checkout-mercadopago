package com.api.pay.model.ml;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
public class Pagamento {

    @Id
    private Long id;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAprovacao;
    private OffsetDateTime ultimaAtualizacao;
    private OffsetDateTime dataExpiracao;
    private OffsetDateTime dataEstorno;
    private String tipoOperacao;
    private String issuerId;
    private String metodoPagamento;
    private String status;
    private String detalhes;
    private BigDecimal valor;
    private BigDecimal total;
    private BigDecimal valorParcela;
    private int parcelas;
    private String quatroDigitosCartao;
    @Transient
    private String qrCodeBase64;
    @Transient
    private String qrCode;
    @Transient
    private String url;
    @Transient
    private String barcode;
    @OneToOne(cascade = CascadeType.ALL)
    private Transacao transacao;

    public Pagamento() {}

    public Pagamento(Long id, String metodoPagamento, String status, String detalhes, BigDecimal valor) {
        this.id = id;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
        this.detalhes = detalhes;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public OffsetDateTime getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(OffsetDateTime dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public OffsetDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(OffsetDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public OffsetDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(OffsetDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public OffsetDateTime getDataEstorno() {
        return dataEstorno;
    }

    public void setDataEstorno(OffsetDateTime dataEstorno) {
        this.dataEstorno = dataEstorno;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getQuatroDigitosCartao() {
        return quatroDigitosCartao;
    }

    public void setQuatroDigitosCartao(String quatroDigitosCartao) {
        this.quatroDigitosCartao = quatroDigitosCartao;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

