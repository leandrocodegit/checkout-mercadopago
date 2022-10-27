package com.api.pay.model.ml;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class EmbeddedPaymentTransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("financial_institution")
    private String financialInstitution;
    @JsonProperty("net_received_amount")
    private BigDecimal netReceivedAmount;
    @JsonProperty("total_paid_amount")
    private BigDecimal totalPaidAmount;
    @JsonProperty("installment_amount")
    private BigDecimal installmentAmount;
    @JsonProperty("overpaid_amount")
    private BigDecimal overpaidAmount;
    @JsonProperty("external_resource_url")
    private String externalResourceUrl;
    @JsonProperty("payment_method_reference_id")
    private String paymentMethodReferenceId;
    @JsonProperty("acquirer_reference")
    private String acquirerReference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFinancialInstitution() {
        return financialInstitution;
    }

    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public BigDecimal getNetReceivedAmount() {
        return netReceivedAmount;
    }

    public void setNetReceivedAmount(BigDecimal netReceivedAmount) {
        this.netReceivedAmount = netReceivedAmount;
    }

    public BigDecimal getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(BigDecimal totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigDecimal installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public BigDecimal getOverpaidAmount() {
        return overpaidAmount;
    }

    public void setOverpaidAmount(BigDecimal overpaidAmount) {
        this.overpaidAmount = overpaidAmount;
    }

    public String getExternalResourceUrl() {
        return externalResourceUrl;
    }

    public void setExternalResourceUrl(String externalResourceUrl) {
        this.externalResourceUrl = externalResourceUrl;
    }

    public String getPaymentMethodReferenceId() {
        return paymentMethodReferenceId;
    }

    public void setPaymentMethodReferenceId(String paymentMethodReferenceId) {
        this.paymentMethodReferenceId = paymentMethodReferenceId;
    }

    public String getAcquirerReference() {
        return acquirerReference;
    }

    public void setAcquirerReference(String acquirerReference) {
        this.acquirerReference = acquirerReference;
    }
}
