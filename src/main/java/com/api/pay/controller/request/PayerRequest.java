package com.api.pay.controller.request;


import com.api.pay.valid.OnPix;
import com.api.pay.valid.OnCard;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PayerRequest {

    @NotBlank(groups = OnPix.class)
    private String nome;
    @NotBlank(groups = {OnCard.class, OnPix.class})
    private String email;
    @NotNull(groups = OnCard.class)
    private PayerIdentificationRequest identification;

    public PayerRequest() { }

    public PayerRequest(String nome, String email, PayerIdentificationRequest identification) {
        this.nome = nome;
        this.email = email;
        this.identification = identification;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PayerIdentificationRequest getIdentification() {
        return identification;
    }

    public void setIdentification(PayerIdentificationRequest identification) {
        this.identification = identification;
    }
}
