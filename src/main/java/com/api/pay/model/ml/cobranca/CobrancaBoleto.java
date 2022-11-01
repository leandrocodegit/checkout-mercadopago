package com.api.pay.model.ml.cobranca;


import com.api.pay.model.ml.checkout.Boleto;

public class CobrancaBoleto implements CobrancaFactory{

    @Override
    public Cobranca processar() {
        return new Boleto();
    }
}
