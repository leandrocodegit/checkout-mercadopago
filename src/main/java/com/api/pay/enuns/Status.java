package com.api.pay.enuns;

public enum Status {

    ATIVO("ATIVO"),
    INATIVO("INATIVO"),
    RECESSO("RECESSO"),
    ANALISE("ANALISE");

    private String value;
    Status(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
