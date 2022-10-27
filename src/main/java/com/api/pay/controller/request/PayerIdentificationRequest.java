package com.api.pay.controller.request;


import javax.validation.constraints.NotNull;


public class PayerIdentificationRequest {

    @NotNull
    private String type;
    @NotNull
    private String number;

    public PayerIdentificationRequest() {}

    public PayerIdentificationRequest(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
