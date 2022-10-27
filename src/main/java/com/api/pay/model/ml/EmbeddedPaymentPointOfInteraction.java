package com.api.pay.model.ml;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class EmbeddedPaymentPointOfInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    @JsonProperty("transaction_data")
    private EmbeddedPix transactionData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmbeddedPix getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(EmbeddedPix transactionData) {
        this.transactionData = transactionData;
    }
}
