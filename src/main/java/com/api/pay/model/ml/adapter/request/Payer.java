package com.api.pay.model.ml.adapter.request;

import com.mercadopago.client.common.IdentificationRequest;

public class Payer {

    private String email;
    private IdentificationRequest identification;
    private String firstName;
    private String lastName;
    private Address address;

    public Payer() {}

    public Payer(String email, String firstName, String lastName, IdentificationRequest identification, Address address) {
        this.email = email;
        this.identification = identification;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IdentificationRequest getIdentification() {
        return identification;
    }

    public void setIdentification(IdentificationRequest identification) {
        this.identification = identification;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
