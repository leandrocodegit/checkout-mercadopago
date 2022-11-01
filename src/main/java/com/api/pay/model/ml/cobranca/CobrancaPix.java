package com.api.pay.model.ml.cobranca;

import com.api.pay.model.ml.checkout.Pix;

public class CobrancaPix implements CobrancaFactory{

    @Override
    public Cobranca processar() {
        return new Pix();
    }
}
