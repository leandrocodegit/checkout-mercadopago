package com.api.pay.controller.response;

import javax.validation.constraints.NotNull;


public class PayerResponse {

    @NotNull
    private String email;
    @NotNull
    private PayerIdentificationResponse identification;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PayerIdentificationResponse getIdentification() {
        return identification;
    }

    public void setIdentification(PayerIdentificationResponse identification) {
        this.identification = identification;
    }
}
