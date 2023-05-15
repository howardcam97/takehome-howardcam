package com.web.api.entity;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {

    private String customerId;
    private double purchaseAmount;
    private LocalDate transactionDate;

    public Transaction(String customerId, double purchaseAmount, LocalDate transactionDate) {
        this.customerId = customerId;
        this.purchaseAmount = purchaseAmount;
        this.transactionDate = transactionDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}

