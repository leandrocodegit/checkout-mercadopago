package com.api.pay.controller.response;

public class QRCodeResponse {
    private String image64;

    public QRCodeResponse(String image64) {
        this.image64 = image64;
    }

    public String getImage64() {
        return image64;
    }

    public void setImage64(String image64) {
        this.image64 = image64;
    }
}
