package com.api.pay.model.ml.adapter;

import com.mercadopago.resources.payment.Payment;

public class PaymentAdapter extends Payment {

    private QRCode barcode;

    public QRCode getBarcode() {
        return barcode;
    }

    public void setBarcode(QRCode barcode) {
        this.barcode = barcode;
    }
}
