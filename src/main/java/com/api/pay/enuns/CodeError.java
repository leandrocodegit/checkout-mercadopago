package com.api.pay.enuns;

public enum CodeError {

    NOT_FOUND("001"),
    DUPLICATE("002"),
    ACTIVE("003"),
    INACTIVE("004"),
    ADDRESS_NOT_FOUND("005"),
    ENDERECO_BLANK("006"),
    FORMAT_INVALID("007"),
    PARAM_INVALID("008"),
    REST_ERROR("009"),
    STOCK_ERROR("010"),
    AGE_ACCEPT("011"),
    ACTIVE_RESPONSE("012"),
    SALDO_ERROR("013"),
    FILE_ERROR("014"),
    CONTENT_INVALID("015"),
    CONTENT_EMPTY("016"),
    DATA_BASE("017"),
    PRICE_ERROR("018"),
    STATUS_ERROR("019"),
    PAY_ERROR("020"),
    PAY_API_ERROR("021");
    private String value;

    CodeError(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
