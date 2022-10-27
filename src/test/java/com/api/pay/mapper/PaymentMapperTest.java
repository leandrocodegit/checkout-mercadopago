package com.api.pay.mapper;

import com.api.pay.build.ConfiguracaoPadraoController;
import com.api.pay.build.PaymentBuild;
import com.api.pay.model.ml.EmbeddedCard;
import com.api.pay.model.ml.EmbeddedPayment;
import com.api.pay.model.ml.EmbeddedPaymentTransactionDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.net.MPResponse;
import com.mercadopago.resources.payment.Payment;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

public class PaymentMapperTest {

   // @Autowired
    private PayMapper mapper = Mappers.getMapper(PayMapper.class);

    @Test
    public void testMapperPayment (){

        Payment pay = PaymentBuild.createPayment();

        EmbeddedPayment embeddedPayment = PayMapper.MAPPER.toConvert(pay);

        Assertions.assertEquals(pay.getIssuerId(), embeddedPayment.getIssuerId());
//        Assertions.assertInstanceOf(EmbeddedCard.class,embeddedPayment.getCard());
//        Assertions.assertInstanceOf(EmbeddedPaymentTransactionDetails.class,embeddedPayment.getTransactionDetails());

    }

}
