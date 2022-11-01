package com.api.pay.mapper;

import com.api.pay.controller.response.PagamentoResponse;
import com.api.pay.model.ml.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PayMapper {

    PayMapper MAPPER = Mappers.getMapper(PayMapper.class);

    public PagamentoResponse toResponse(Pagamento entity);


}
