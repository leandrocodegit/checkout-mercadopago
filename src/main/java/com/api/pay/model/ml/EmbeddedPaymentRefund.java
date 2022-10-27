package com.api.pay.model.ml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadopago.resources.common.Source;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "embedded_payment_refund")
public class EmbeddedPaymentRefund {
    @Id
    private Long id;
    @JsonProperty("payment_id")
    private Long paymentId;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("adjustment_amount")
    private BigDecimal adjustmentAmount;
    @JsonProperty("status")
    private String status;
    @JsonProperty("refund_mode")
    private String refundMode;
    @JsonProperty("date_created")
    private OffsetDateTime dateCreated;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("unique_sequence_number")
    private String uniqueSequenceNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setAdjustmentAmount(BigDecimal adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRefundMode() {
        return refundMode;
    }

    public void setRefundMode(String refundMode) {
        this.refundMode = refundMode;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUniqueSequenceNumber() {
        return uniqueSequenceNumber;
    }

    public void setUniqueSequenceNumber(String uniqueSequenceNumber) {
        this.uniqueSequenceNumber = uniqueSequenceNumber;
    }

}
