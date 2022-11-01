package com.api.pay.controller.request;

import com.api.pay.controller.request.validations.OnAll;
import com.api.pay.controller.request.validations.OnBoleto;
import com.api.pay.controller.request.validations.OnCard;
import com.api.pay.model.ml.Usuario;
import org.checkerframework.checker.index.qual.Positive;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransacaoRequest {

    @Positive
    @Min(value = 20, groups = {OnAll.class, OnBoleto.class})
    private Double valor;
    @NotBlank(groups = {OnAll.class})
    @NotNull(groups = {OnAll.class})
    private String numeroPedido;
    @NotBlank(groups = {OnCard.class})
    @NotNull(groups = {OnCard.class})
    private String metodoPagamento;
    @NotNull(groups = {OnAll.class})
    @Valid
    private UsuarioRequest usuario;
    @Positive
    @Min(value = 1, groups = {OnCard.class})
    private int parcelas;
    @NotBlank(groups = {OnCard.class})
    @NotNull(groups = {OnCard.class})
    private String token;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }


    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public UsuarioRequest getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioRequest usuario) {
        this.usuario = usuario;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
