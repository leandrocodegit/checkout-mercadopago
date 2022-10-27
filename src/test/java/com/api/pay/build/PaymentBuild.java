package com.api.pay.build;

import com.mercadopago.resources.payment.Payment;

public class PaymentBuild {

    public static Payment createPayment(){
        return new Payment();
    }
}
