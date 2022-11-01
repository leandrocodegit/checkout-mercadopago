package com.api.pay.model.ml.adapter.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.client.payment.PaymentPayerRequest;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;



public class BoletoPaymentRequest {

    @JsonProperty("transaction_amount")
    private BigDecimal transactionAmount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("payment_method_id")
    private String paymentMethodId;
    @JsonProperty("payer")
    private Payer payer;
    @JsonProperty("address")
    private Address address;

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
