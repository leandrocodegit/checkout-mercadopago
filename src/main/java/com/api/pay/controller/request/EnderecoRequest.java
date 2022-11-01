package com.api.pay.controller.request;

import com.api.pay.controller.request.validations.OnBoleto;
import com.api.pay.controller.request.validations.OnCard;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class EnderecoRequest {

    @NotBlank(groups = {OnBoleto.class})
    @NotNull(groups = {OnBoleto.class})
    private String cep;
    @NotBlank(groups = {OnBoleto.class})
    @NotNull(groups = {OnBoleto.class})
    private String logradouro;
    @NotBlank(groups = {OnBoleto.class})
    @NotNull(groups = {OnBoleto.class})
    private String numero;
    @NotBlank(groups = {OnBoleto.class})
    @NotNull(groups = {OnBoleto.class})
    private String bairro;
    @NotBlank(groups = {OnBoleto.class})
    @NotNull(groups = {OnBoleto.class})
    private String cidade;
    @NotBlank(groups = {OnBoleto.class})
    @NotNull(groups = {OnBoleto.class})
    private String uf;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
