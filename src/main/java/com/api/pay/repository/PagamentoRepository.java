package com.api.pay.repository;

import com.api.pay.model.ml.Pagamento;
import com.api.pay.model.ml.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {

    public Optional<Pagamento> findByTransacao(Transacao transacao);
}
