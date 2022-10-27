package com.api.pay.controller.request;

import com.api.pay.valid.OnCard;
import com.api.pay.valid.OnPedido;
import com.api.pay.valid.OnPix;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PaymentRequest {

    @NotBlank(groups = OnCard.class)
    private String token;
    @NotBlank(groups = OnCard.class)
    @JsonProperty("issuer_id")
    private String issuerId;
    @NotBlank(groups = OnCard.class)
    @JsonProperty("payment_method_id")
    private String paymentMethodId;
    @NotNull(groups = {OnCard.class, OnPix.class})
    @JsonProperty("transaction_amount")
    private BigDecimal transactionAmount;
    @NotNull(groups = OnCard.class)
    private Integer installments;
    @NotBlank(groups = {OnCard.class, OnPix.class, OnPedido.class})
    @JsonProperty("numero_pedido")
    private String numeroPedido;
    @Valid
    @NotNull(groups = {OnCard.class, OnPix.class})
    private PayerRequest payer;

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "token='" + token + '\'' +
                ", issuerId='" + issuerId + '\'' +
                ", paymentMethodId='" + paymentMethodId + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", installments=" + installments +
                ", numeroPedido='" + numeroPedido + '\'' +
                ", payer=" + payer +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public PayerRequest getPayer() {
        return payer;
    }

    public void setPayer(PayerRequest payer) {
        this.payer = payer;
    }
}
