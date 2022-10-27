package com.api.pay.exceptions;

import com.api.pay.enuns.CodeError;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
       switch (response.status()) {
           case 400: throw new EntityResponseException("Response erro 400", CodeError.REST_ERROR);
           case 403: throw new  EntityResponseException("Response erro 403",CodeError.REST_ERROR);
           case 404: throw new EntityResponseException("Response erro 404",CodeError.REST_ERROR);
           default: return new EntityResponseException("Error interno",CodeError.REST_ERROR);
        }
    }
}
