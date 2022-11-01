package com.api.pay.model.ml.model;

import com.api.pay.model.ml.Endereco;
import com.api.pay.model.ml.Transacao;
import com.api.pay.model.ml.Usuario;

public class TransacaoBuilder {

    private Transacao instance;

    public TransacaoBuilder() {
        this.instance = new Transacao();
    }

    public TransacaoBuilder setCard(Double valor, String numeroPedido, int parcelas, String token, String metodoPagamento) {
        instance.setValor(valor);
        instance.setNumeroPedido(numeroPedido);
        instance.setParcelas(parcelas);
        instance.setToken(token);
        instance.setMetodoPagamento(metodoPagamento);
        return this;
    }

    public TransacaoBuilder setPix(Double valor, String numeroPedido) {
        instance.setValor(valor);
        instance.setNumeroPedido(numeroPedido);
        instance.setMetodoPagamento("pix");
        return this;
    }

    public TransacaoBuilder setBoleto(Double valor, String numeroPedido) {
        instance.setValor(valor);
        instance.setNumeroPedido(numeroPedido);
        instance.setMetodoPagamento("ticket");
        return this;
    }

    public TransacaoBuilder setUsuario(String email, String nome, TipoDocumento tipoDocumento, String documento){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setTipoDocumento(tipoDocumento);
        usuario.setDocumento(documento);
        instance.setUsuario(usuario);
        return this;
    }

    public TransacaoBuilder setEndereco(String cep, String logradouro, String numero, String bairro, String cidade, String uf){
        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setUf(uf);
        instance.getUsuario().setEndereco(endereco);
        return this;
    }

    public Transacao builder(){
        return instance;
    }

}
