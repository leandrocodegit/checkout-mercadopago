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
import com.api.pay.rest.RestMercadoPago;
import com.api.pay.rest.RestPedido;
import com.api.pay.rest.fallbacks.Pedido;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.payment.PaymentRefund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
public class PaymentService {

    @Value("${mercadopago.access.token}")
    private String mercadoPagoAccessToken;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private SendRabbitMQService sendRabbitMQService;
    @Autowired
    private RestMercadoPago restMercadoPago;
    @Autowired
    private RestPedido restPedido;

    public EmbeddedPayment buscaPagamentoId(Long id){
       return paymentRepository.findById(id).orElseThrow( () ->
              new EntityResponseException("Transacao nao registrada", CodeError.NOT_FOUND)
        );
    }


    public EmbeddedPayment atualizaPagamento(Long id){

        try {
            EmbeddedPayment payment = buscaPagamentoId(id);
            EmbeddedPayment paymentResponse = restMercadoPago.findPayment(id);
            MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
            payment.setStatusDetail(paymentResponse.getStatusDetail());
            payment.setStatus(paymentResponse.getStatus());
            payment.setDateLastUpdated(paymentResponse.getDateLastUpdated());
            paymentRepository.save(payment);
            sendRabbitMQService.sendRabbitMQ(new MensagemSend(
                    TypeSend.PAY,
                    TypeSend.CHANGE,
                    payment.getId().toString(),
                    payment.getDescription()));
            return payment;
        }catch (Exception ex){
            ex.printStackTrace();
            throw new EntityResponseException("Erro ao atualizar", CodeError.REST_ERROR);
        }
    }

    public EmbeddedPayment estornarPagamento(Long id){
        try {
            EmbeddedPayment payment = buscaPagamentoId(id);
            MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
            PaymentClient paymentClient = new PaymentClient();
            PaymentRefund paymentRefund = paymentClient.refund(id);
            payment.setPaymentRefund(PayMapper.MAPPER.toConvert(paymentRefund));
            System.out.println(paymentRefund.toString());
            System.err.println(paymentRefund.getId().toString());
            sendRabbitMQService.sendRabbitMQ(new MensagemSend(
                    TypeSend.PAY,
                    TypeSend.REFUND,
                    payment.getId().toString(),
                    payment.getDescription()));
            paymentRepository.save(payment);
            return payment;
        }catch (Exception ex){
            throw new EntityResponseException("Erro ao estornar", CodeError.REST_ERROR);
        }
    }

    public PaymentResponse processCardPayment(PaymentRequest request) {
        try {

            System.err.println(request.toString());
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
            embeddedPayment = paymentRepository.save(embeddedPayment);

//            sendRabbitMQService.sendRabbitMQ(new MensagemSend(
//                    TypeSend.PAY,
//                    TypeSend.CREATE,
//                    embeddedPayment.getId().toString(),
//                    embeddedPayment.getDescription()));

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

    public EmbeddedPayment criarPaymentPix(PaymentRequest request) {

        if (!restPedido.pedidoIsValido(request.getNumeroPedido()))
            throw new EntityResponseException("Erro no pedido", CodeError.PRICE_ERROR);
        try {
            PaymentClient client = new PaymentClient();
            MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
            PaymentCreateRequest paymentCreateRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(request.getTransactionAmount())
                            .description(request.getNumeroPedido())
                            .paymentMethodId("pix")
                            .dateOfExpiration(OffsetDateTime.now().plusMinutes(30))
                            .payer(
                                    PaymentPayerRequest.builder()
                                            .email(request.getPayer().getEmail())
                                            .firstName(request.getPayer().getNome())
                                            .lastName(request.getPayer().getNome())
                                            .identification(
                                                    IdentificationRequest.builder()
                                                            .type(request.getPayer().getIdentification().getType())
                                                            .number(request.getPayer().getIdentification().getNumber())
                                                            .build())
                                            .build())
                            .build();

            EmbeddedPayment embeddedPayment = PayMapper.MAPPER.toConvert(client.create(paymentCreateRequest));
            paymentRepository.save(embeddedPayment);

//            sendRabbitMQService.sendRabbitMQ(new MensagemSend(
//                    TypeSend.PAY,
//                    TypeSend.CREATE,
//                    embeddedPayment.getId().toString(),
//                    embeddedPayment.getDescription()));
            return embeddedPayment;
        } catch (MPApiException apiException) {
            throw new EntityResponseException("Erro ao processar pix", CodeError.PAY_API_ERROR);
        } catch (MPException exception) {
            throw new EntityResponseException("Erro ao processar pagamento", CodeError.PAY_ERROR);
        }
    }

        public EmbeddedPayment criarPaymentPix(String numeroPedido) {

            Pedido pedido = restPedido.buscaPedido(numeroPedido);
            System.out.println("Pedido");

            if(!restPedido.pedidoIsValido(numeroPedido))
                throw new EntityResponseException("Erro no pedido", CodeError.PRICE_ERROR);
            try {
                PaymentClient client = new PaymentClient();
                MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
                PaymentCreateRequest paymentCreateRequest =
                        PaymentCreateRequest.builder()
                                .transactionAmount(new BigDecimal(pedido.getTotal().toString()).setScale(2))
                                .description(numeroPedido)
                                .paymentMethodId("pix")
                                //.dateOfExpiration(OffsetDateTime.now().plusMinutes(30))
                                .payer(
                                        PaymentPayerRequest.builder()
                                                .email(pedido.getUsuario().getEmail())
                                                .firstName(pedido.getUsuario().getNome())
                                                .lastName(pedido.getUsuario().getNome())
                                                .identification(
                                                        IdentificationRequest.builder()
                                                                .type("CPF")
                                                                .number(pedido.getUsuario().getDocumento())
                                                                .build())
                                                .build())
                                .build();

                EmbeddedPayment embeddedPayment = PayMapper.MAPPER.toConvert(client.create(paymentCreateRequest));
                paymentRepository.save(embeddedPayment);

//                sendRabbitMQService.sendRabbitMQ(new MensagemSend(
//                        TypeSend.PAY,
//                        TypeSend.CREATE,
//                        embeddedPayment.getId().toString(),
//                        embeddedPayment.getDescription()));
                return embeddedPayment;
            }
            catch (MPApiException apiException) {
                //apiException.printStackTrace();
                throw new EntityResponseException("Erro ao processar pix", CodeError.PAY_API_ERROR);
            } catch (MPException exception) {
                throw new EntityResponseException("Erro ao processar pagamento", CodeError.PAY_ERROR);
            }
    }


    public EmbeddedPayment cancelarPix(Long id, boolean notifique) {
        try {
            PaymentClient client = new PaymentClient();
            MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);

            EmbeddedPayment embeddedPayment = buscaPagamentoId(id);
            if(embeddedPayment.getPaymentMethodId().equals("pix"))
                if(!embeddedPayment.getStatus().equals("pending"))
                    throw new EntityResponseException("Nao é possivel cancelar " + embeddedPayment.getPaymentMethodId(), CodeError.PAY_API_ERROR);

            System.out.println(embeddedPayment.getPaymentMethodId() + " " + !embeddedPayment.getPaymentMethodId().equals("pix") );
            if(!embeddedPayment.getPaymentMethodId().equals("pix"))
                throw new EntityResponseException("Nao é possivel cancelar " + embeddedPayment.getPaymentMethodId(), CodeError.PAY_API_ERROR);
            paymentRepository.save(PayMapper.MAPPER.toConvert(client.cancel(id)));
            if(notifique)
                sendRabbitMQService.sendRabbitMQ(new MensagemSend(
                    TypeSend.PAY,
                    TypeSend.CANCEL,
                    embeddedPayment.getId().toString(),
                    embeddedPayment.getDescription()));
            return embeddedPayment;
        } catch (EntityResponseException apiException) {
            apiException.printStackTrace();
            throw new EntityResponseException("Erro ao cancelar pagamento", CodeError.PAY_API_ERROR);
        } catch (Exception exception) {
            throw new EntityResponseException("Erro ao processar cancelamento", CodeError.PAY_ERROR);
        }
    }



}
