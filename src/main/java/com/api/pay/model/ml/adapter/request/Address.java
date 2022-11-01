package com.api.pay.model.ml.adapter.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("zip_code")
    private String zipCode;
    @JsonProperty("street_name")
    private String streetName;
    @JsonProperty("street_number")
    private String streetNumber;
    @JsonProperty("city")
    private String city;
    @JsonProperty("neighborhood")
    private String neighborhood;
    @JsonProperty("federal_unit")
    private String federalUnit;

    public Address() {}

    public Address(String zipCode, String streetName, String streetNumber, String city, String neighborhood, String federalUnit) {
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.neighborhood = neighborhood;
        this.federalUnit = federalUnit;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getFederalUnit() {
        return federalUnit;
    }

    public void setFederalUnit(String federalUnit) {
        this.federalUnit = federalUnit;
    }
}
