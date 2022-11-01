package com.api.pay.model.ml.checkout;


import com.api.pay.model.ml.adapter.MercadoPagoAdapter;
import com.api.pay.model.ml.adapter.MercadopagoClientAdapter;
import com.api.pay.model.ml.cobranca.Cobranca;
import com.api.pay.model.ml.Pagamento;
import com.api.pay.model.ml.Transacao;

public class Credito implements Cobranca {


    @Override
    public Pagamento criarCobranca(Transacao transacao) {
        MercadoPagoAdapter pay = new MercadoPagoAdapter();
        return pay.gerarCobrancaCartao(transacao);
    }

    @Override
    public Pagamento cancelarCobranca(Pagamento pagamento) {
        MercadoPagoAdapter pay = new MercadoPagoAdapter();
        return pay.cancelarCobranca(pagamento);
    }

    @Override
    public Pagamento estornarCobranca(Pagamento pagamento) {
        MercadoPagoAdapter pay = new MercadoPagoAdapter();
        return pay.estornarCobranca(pagamento);
    }

    @Override
    public Pagamento buscarCobranca(Long id) {
        MercadopagoClientAdapter pay = new MercadopagoClientAdapter();
        return pay.buscarCobranca(id);
    }
}
