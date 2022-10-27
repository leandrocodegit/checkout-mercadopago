package com.api.pay.model.ml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Entity
public class EmbeddedPayment {

    @Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("date_created")
    private OffsetDateTime dateCreated;
    @JsonProperty("date_approved")
    private OffsetDateTime dateApproved;
    @JsonProperty("date_last_updated")
    private OffsetDateTime dateLastUpdated;
    @JsonProperty("date_of_expiration")
    private OffsetDateTime dateOfExpiration;
    @JsonProperty("money_release_date")
    private OffsetDateTime moneyReleaseDate;
    @JsonProperty("money_release_schema")
    private String moneyReleaseSchema;
    @JsonProperty("operation_type")
    private String operationType;
    @JsonProperty("issuer_id")
    private String issuerId;
    @JsonProperty("payment_method_id")
    private String paymentMethodId;
    @JsonProperty("payment_type_id")
    private String paymentTypeId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("status_detail")
    private String statusDetail;
    @JsonProperty("currency_id")
    private String currencyId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("transaction_amount")
    private BigDecimal transactionAmount;
    @JsonProperty("transaction_amount_refunded")
    private BigDecimal transactionAmountRefunded;
    @JsonProperty("coupon_amount")
    private BigDecimal couponAmount;
    @JsonProperty("installments")
    private int installments;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("transaction_details")
    private EmbeddedPaymentTransactionDetails transactionDetails;
    @OneToOne(cascade = CascadeType.ALL)
    private EmbeddedCard card;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("payment_refund")
    private EmbeddedPaymentRefund paymentRefund;

    @JsonProperty("point_of_interaction")
    @OneToOne(cascade = CascadeType.ALL)
    private EmbeddedPaymentPointOfInteraction pointOfInteraction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(OffsetDateTime dateApproved) {
        this.dateApproved = dateApproved;
    }

    public OffsetDateTime getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(OffsetDateTime dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public OffsetDateTime getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(OffsetDateTime dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public OffsetDateTime getMoneyReleaseDate() {
        return moneyReleaseDate;
    }

    public void setMoneyReleaseDate(OffsetDateTime moneyReleaseDate) {
        this.moneyReleaseDate = moneyReleaseDate;
    }

    public String getMoneyReleaseSchema() {
        return moneyReleaseSchema;
    }

    public void setMoneyReleaseSchema(String moneyReleaseSchema) {
        this.moneyReleaseSchema = moneyReleaseSchema;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getTransactionAmountRefunded() {
        return transactionAmountRefunded;
    }

    public void setTransactionAmountRefunded(BigDecimal transactionAmountRefunded) {
        this.transactionAmountRefunded = transactionAmountRefunded;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public EmbeddedPaymentTransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(EmbeddedPaymentTransactionDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public EmbeddedCard getCard() {
        return card;
    }

    public void setCard(EmbeddedCard card) {
        this.card = card;
    }

    public EmbeddedPaymentRefund getPaymentRefund() {
        return paymentRefund;
    }

    public void setPaymentRefund(EmbeddedPaymentRefund paymentRefund) {
        this.paymentRefund = paymentRefund;
    }

    public EmbeddedPaymentPointOfInteraction getPointOfInteraction() {
        return pointOfInteraction;
    }

    public void setPointOfInteraction(EmbeddedPaymentPointOfInteraction pointOfInteraction) {
        this.pointOfInteraction = pointOfInteraction;
    }
}
