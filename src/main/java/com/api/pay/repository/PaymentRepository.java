package com.api.pay.repository;

import com.api.pay.model.ml.EmbeddedPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<EmbeddedPayment,Long> {

    public Optional<EmbeddedPayment> findByDescription(String numeroPedido);
}
