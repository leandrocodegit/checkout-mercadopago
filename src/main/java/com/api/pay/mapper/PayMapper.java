package com.api.pay.mapper;

import com.api.pay.controller.response.*;
import com.api.pay.model.ml.*;
import com.mercadopago.resources.payment.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PayMapper {

    PayMapper MAPPER = Mappers.getMapper(PayMapper.class);
    public EmbeddedPayment toConvert(Payment payment);
    public EmbeddedPaymentTransactionDetails toConvert(PaymentTransactionDetails transactionDetails);
    public EmbeddedCard toConvert(PaymentCard card);
    public EmbeddedPaymentRefund toConvert(PaymentRefund paymentRefund);
    public EmbeddedPaymentPointOfInteraction toConvert(PaymentPointOfInteraction paymentPointOfInteraction);
    public EmbeddedPix toConvert(PaymentTransactionData paymentTransactionData);
    public EmbeddedPaymentResponse toResponse(EmbeddedPayment entity);
    public EmbeddedPaymentPIXResponse toPIXResponse(EmbeddedPayment entity);
    public EmbeddedPixResponse toPIXResponse(EmbeddedPix entity);
    public EmbeddedPaymentRefundResponse toResponse(EmbeddedPaymentRefund entity);
    public EmbeddedPaymentTransactionDetailsResponse toResponse(EmbeddedPaymentTransactionDetails entity);

}
