package com.api.pay.exceptions;

import com.api.pay.enuns.CodeError;
import lombok.Getter;
import lombok.Setter;

public class EntityResponseException extends RuntimeException{
    private CodeError codeError;
    public EntityResponseException(String mensagem, CodeError codeError){
        super(mensagem);
        this.codeError = codeError;
    }

    public CodeError getCodeError() {
        return codeError;
    }

    public void setCodeError(CodeError codeError) {
        this.codeError = codeError;
    }
}
