package com.api.pay.model.ml.cobranca;

import com.api.pay.model.ml.Pagamento;
import com.api.pay.model.ml.Transacao;

public interface Cobranca {

    public Pagamento criarCobranca(Transacao transacao);
    public Pagamento cancelarCobranca(Pagamento pagamento);
    public Pagamento estornarCobranca(Pagamento pagamento);
    public Pagamento buscarCobranca(Long id);
}
