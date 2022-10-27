package com.api.pay.rest.fallbacks;

import org.springframework.stereotype.Component;

@Component
public class Pedido{

    private Registro registro;
    private Double total;
    private Usuario usuario;

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + registro.getIdentificador() +
                ", total=" + total +
                ", usuario=" + usuario +
                '}';
    }
}
