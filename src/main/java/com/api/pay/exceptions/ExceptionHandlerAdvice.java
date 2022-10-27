package com.api.pay.exceptions;

import com.api.pay.enuns.CodeError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.UnexpectedTypeException;
import java.sql.SQLException;
import java.util.LinkedList;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityResponseException.class)
    public ResponseEntity<ResponseError> handlerEntityNotFoundException(EntityResponseException ex) {
        return new ResponseEntity<ResponseError>(new
                ResponseError(ex.getMessage(),
                ex.getCodeError().name(),
                ex.getCodeError().getValue(),
                new LinkedList<String>() {{
                    add("");
                }}),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ResponseError> handlerValidadeException(SQLException ex) {
        return new ResponseEntity<ResponseError>(
                new ResponseError(
                        "",
                        CodeError.DATA_BASE.name(),
                        CodeError.DATA_BASE.getValue(),
                        new LinkedList<String>() {{
                            add(ex.getLocalizedMessage());
                        }}
                ),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<ResponseError> handlerValidadeException(UnexpectedTypeException ex) {
        return new ResponseEntity<ResponseError>(
                new ResponseError(
                        "Formato invalido",
                        CodeError.FORMAT_INVALID.name(),
                        CodeError.FORMAT_INVALID.getValue(),
                        new LinkedList<String>() {{
                            add(ex.getLocalizedMessage());
                        }}
                ),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> handlerValidadeException(IllegalArgumentException ex) {
        return new ResponseEntity<ResponseError>(
                new ResponseError(
                        "Id invalido",
                        CodeError.FORMAT_INVALID.name(),
                        CodeError.FORMAT_INVALID.getValue(),
                        new LinkedList<String>() {{
                            add(ex.getLocalizedMessage());
                        }}
                ),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.badRequest().body(
                new ResponseError(
                        "Formato invalido",
                        CodeError.FORMAT_INVALID.name(),
                        CodeError.FORMAT_INVALID.getValue(),
                        new LinkedList<String>() {{
                            add(ex.getLocalizedMessage());
                            add(ex.getBindingResult().getAllErrors().get(0).getCode().toString());
                            add(ex.getBindingResult().getAllErrors().get(0).getObjectName().toString());
                            add(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage().toString());
                        }}
                ));
    }

}