package com.api.pay.publish;

public class MensagemSend {
    private TypeSend typeSend;
    private TypeSend status;
    private String fromId;
    private String toId;

    public MensagemSend() {
    }

    public MensagemSend(TypeSend typeSend, TypeSend status, String fromId, String toId) {
        this.typeSend = typeSend;
        this.status = status;
        this.fromId = fromId;
        this.toId = toId;
    }

    public TypeSend getTypeSend() {
        return typeSend;
    }

    public void setTypeSend(TypeSend typeSend) {
        this.typeSend = typeSend;
    }

    public TypeSend getStatus() {
        return status;
    }

    public void setStatus(TypeSend status) {
        this.status = status;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}


