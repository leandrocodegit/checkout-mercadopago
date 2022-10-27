package com.api.pay.enuns;

public enum Tradutor {

    PAYMENT_STATUS;

    private String value;

    public String VALUE(String value){
        switch (value) {
            case "approved":
                value = "Aprovado";
                break;
            case "accredited":
                value = "Autorizado";
                break;
            case "rejected":
                value = "Recusado";
                break;
            case "refunded":
                value = "Estornado";
                break;
            case "in_process":
                value = "Analise";
                break;
            case "pending_contingency":
                value = "Aguardando confirmação";
                break;
            case "pending":
                value = "Pendente";
                break;
            case "cancelled":
                value = "Cancelado";
                break;
            case "pending_waiting_transfer":
                value = "Aguarndado pagamento";
                break;
            case "by_collector":
                value = "Processado";
                break;
            case "cc_rejected_other_reason":
                value = "Pagamento recusado";
                break;
            case "cc_rejected_call_for_authorize":
                value = "Pagamento recusado";
                break;
            case "cc_rejected_insufficient_amount":
                value = "Limite não autorizado";
                break;
            case "cc_rejected_bad_filled_security_code":
                value = "Dados inválidos";
                break;
            case "cc_rejected_bad_filled_date":
                value = "Dados inválidos";
                break;
            case "cc_rejected_card_error":
                value = "Não conseguimos processar seu pagamento";
                break;
            case "cc_rejected_card_type_not_allowed":
                value = "Cartão não possui função crédito habilitada";
                break;
            default:
                value = "";
        }
        return value;
    }
}
