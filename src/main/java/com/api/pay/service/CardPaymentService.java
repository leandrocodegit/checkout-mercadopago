package com.api.pay.service;

import com.api.pay.controller.request.PaymentRequest;
import com.api.pay.controller.response.PaymentResponse;
import com.api.pay.enuns.CodeError;
import com.api.pay.exceptions.EntityResponseException;
import com.api.pay.mapper.PayMapper;
import com.api.pay.model.ml.EmbeddedPayment;
import com.api.pay.publish.MensagemSend;
import com.api.pay.publish.TypeSend;
import com.api.pay.repository.PaymentRepository;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentService {
    @Value("${mercadopago.access.token}")
    private String mercadoPagoAccessToken;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private SendRabbitMQService sendRabbitMQService;


    public PaymentResponse processPayment(PaymentRequest request) {
        try {
            MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);

            PaymentClient paymentClient = new PaymentClient();

            PaymentCreateRequest paymentCreateRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(request.getTransactionAmount())
                            .token(request.getToken())
                            .description(request.getNumeroPedido())
                            .installments(request.getInstallments())
                            .paymentMethodId(request.getPaymentMethodId())
                            .payer(
                                    PaymentPayerRequest.builder()
                                            .email(request.getPayer().getEmail())
                                            .identification(
                                                    IdentificationRequest.builder()
                                                            .type(request.getPayer().getIdentification().getType())
                                                            .number(request.getPayer().getIdentification().getNumber())
                                                            .build())
                                            .build())
                            .build();

            Payment pay = paymentClient.create(paymentCreateRequest);
            EmbeddedPayment embeddedPayment = PayMapper.MAPPER.toConvert(pay);
            embeddedPayment = savePayment(embeddedPayment);

            sendRabbitMQService.sendRabbitMQ(new MensagemSend(
                    TypeSend.PAY,
                    TypeSend.CREATE,
                    embeddedPayment.getId().toString(),
                    embeddedPayment.getDescription()));

            return new PaymentResponse(
                    pay.getId(),
                    String.valueOf(pay.getStatus()),
                    pay.getStatusDetail());
        } catch (MPApiException apiException) {
            throw new EntityResponseException("Erro ao processar pagamento", CodeError.PAY_API_ERROR);
        } catch (MPException exception) {
            throw new EntityResponseException("Erro ao processar pagamento", CodeError.PAY_ERROR);
        }
    }

    private EmbeddedPayment savePayment(EmbeddedPayment payment){
       return paymentRepository.save(payment);
    }
}