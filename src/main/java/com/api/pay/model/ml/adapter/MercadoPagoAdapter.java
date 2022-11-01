package com.api.pay.model.ml.adapter;

import com.api.pay.model.ml.Pagamento;
import com.api.pay.model.ml.model.PagamentoBuild;
import com.api.pay.model.ml.Transacao;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.payment.PaymentRefund;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class MercadoPagoAdapter extends PaymentClient {

    public MercadoPagoAdapter() {
        MercadoPagoConfig.setAccessToken("TEST-3070472608701511-110619-46cc8dd83c8394c236b931dc6ce796f8-658800087");
    }

    public Pagamento gerarCobrancaCartao(Transacao transacao) {
        try {
            PaymentCreateRequest paymentCreateRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(new BigDecimal(transacao.getValor()))
                            .token(transacao.getToken())
                            .description(transacao.getNumeroPedido())
                            .installments(transacao.getParcelas())
                            .paymentMethodId(transacao.getMetodoPagamento())
                            .payer(
                                    PaymentPayerRequest.builder()
                                            .email(transacao.getUsuario().getEmail())
                                            .identification(
                                                    IdentificationRequest.builder()
                                                            .type(transacao.getUsuario().getTipoDocumento().name())
                                                            .number(transacao.getUsuario().getDocumento())
                                                            .build())
                                            .build())
                            .build();
            Payment payment = super.create(paymentCreateRequest);
            return new PagamentoBuild()
                    .create(
                            payment.getId(),
                            payment.getPaymentMethodId(),
                            payment.getStatus(),
                            payment.getStatusDetail(),
                            payment.getTransactionAmount())
                    .setDatesTime(
                            payment.getDateCreated(),
                            payment.getDateApproved(),
                            payment.getDateLastUpdated())
                    .setTransacao(transacao)
                    .setCardDetalhes(
                            payment.getCard().getLastFourDigits(),
                            payment.getIssuerId(),
                            payment.getTransactionDetails().getInstallmentAmount(),
                            payment.getTransactionDetails().getTotalPaidAmount(),
                            payment.getInstallments())
                    .build();
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Pagamento gerarCobrancaPix(Transacao transacao) {
        try {
            PaymentCreateRequest paymentCreateRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(new BigDecimal(transacao.getValor()))
                            .description(transacao.getNumeroPedido())
                            .paymentMethodId("pix")
                            .dateOfExpiration(OffsetDateTime.now().plusMinutes(30))
                            .payer(
                                    PaymentPayerRequest.builder()
                                            .email(transacao.getUsuario().getEmail())
                                            .identification(
                                                    IdentificationRequest.builder()
                                                            .type(transacao.getUsuario().getTipoDocumento().name())
                                                            .number(transacao.getUsuario().getDocumento())
                                                            .build())
                                            .build())
                            .build();
            Payment payment = super.create(paymentCreateRequest);
            return new PagamentoBuild()
                    .create(
                            payment.getId(),
                            payment.getPaymentMethodId(),
                            payment.getStatus(),
                            payment.getStatusDetail(),
                            payment.getTransactionAmount())
                    .setDatesTime(
                            payment.getDateCreated(),
                            payment.getDateApproved(),
                            payment.getDateLastUpdated())
                    .setTransacao(transacao)
                    .setPixDetalhes(
                            payment.getPointOfInteraction().getTransactionData().getQrCode(),
                            payment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                            payment.getDateOfExpiration())
                    .build();
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Pagamento cancelarCobranca(Pagamento pagamento) {
        try {
            if (pagamento.getTransacao().getMetodoPagamento().equals("pix")) {
                Payment payment = super.cancel(pagamento.getId());
                System.out.println("Cancelando " + pagamento.getId());
                return new PagamentoBuild()
                        .create(
                                payment.getId(),
                                payment.getPaymentMethodId(),
                                payment.getStatus(),
                                payment.getStatusDetail(),
                                payment.getTransactionAmount())
                        .setDatesTime(
                                payment.getDateCreated(),
                                payment.getDateApproved(),
                                payment.getDateLastUpdated())
                        .build();
            } else throw new RuntimeException("Error");
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }


    public Pagamento estornarCobranca(Pagamento pagamento) {
        try {
            if (pagamento.getTransacao().getMetodoPagamento().equals("pix")) {
                PaymentRefund payment = super.refund(pagamento.getId());
                return new PagamentoBuild()
                        .create(payment.getId(), payment.getReason(), payment.getStatus(), payment.getRefundMode(), payment.getAmount())
                        .setEstorno(payment.getDateCreated())
                        .build();
            } else throw new RuntimeException("Error");
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
    }

}
