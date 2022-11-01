package com.api.pay.controller.request;

import com.api.pay.controller.request.validations.OnAll;
import com.api.pay.controller.request.validations.OnBoleto;
import com.api.pay.model.ml.Endereco;
import com.api.pay.model.ml.model.TipoDocumento;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
public class UsuarioRequest {

    @Email(groups = {OnAll.class})
    private String email;
    @NotBlank(groups = {OnAll.class})
    @NotNull(groups = {OnAll.class})
    private String nome;
    @NotNull(groups = {OnAll.class})
    private TipoDocumento tipoDocumento;
    @NotBlank(groups = {OnAll.class})
    @NotNull(groups = {OnAll.class})
    private String documento;
    @NotNull(groups = {OnBoleto.class})
    @Valid
    private EnderecoRequest endereco;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequest endereco) {
        this.endereco = endereco;
    }
}
