package com.api.pay.exceptions;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


public class ResponseError {

    private String message;
    private String type;
    private String codigo;
    private List<String> erros;
    private Boolean containsError = true;
    private Timestamp timestamp = Timestamp.from(Instant.now());

    ResponseError(String message, String type, String codigo, List<String> erros) {
        this.message = message;
        this.type = type;
        this.codigo = codigo;
        this.erros = erros;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public Boolean getContainsError() {
        return containsError;
    }

    public void setContainsError(Boolean containsError) {
        this.containsError = containsError;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
