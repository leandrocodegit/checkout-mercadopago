package com.api.pay.model.ml.cobranca;

import com.api.pay.model.ml.checkout.Credito;

public class CobrancaCredito implements CobrancaFactory{


    @Override
    public Cobranca processar() {
        return new Credito();
    }
}
