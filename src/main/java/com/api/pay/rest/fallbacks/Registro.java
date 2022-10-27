package com.api.pay.rest.fallbacks;

import java.time.LocalDateTime;

public class Registro {

    private int identificador;
    private LocalDateTime data;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
