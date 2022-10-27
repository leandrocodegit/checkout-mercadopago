package com.api.pay.model.ml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class EmbeddedPayer {

    @Id
    @NotNull
    private String email;
    @NotNull
    private String nome;
    @NotNull
    @Transient
    private String firstName;
    @NotNull
    @Transient
    private String lastName;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private EmbeddedPayerIdentification identification;

    public String getFirstName() {
        if(nome.contains(" ")){
            firstName = nome.substring(0, nome.indexOf(" "));
        }
        return firstName;
    }
    public String getLastName() {
        if(nome.contains(" ")){
            lastName = nome.substring(nome.indexOf(" "), nome.length());
        }
        return lastName;
    }

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmbeddedPayerIdentification getIdentification() {
        return identification;
    }

    public void setIdentification(EmbeddedPayerIdentification identification) {
        this.identification = identification;
    }
}
