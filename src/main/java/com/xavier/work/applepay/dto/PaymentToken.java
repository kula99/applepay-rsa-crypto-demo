package com.xavier.work.applepay.dto;

public class PaymentToken extends BaseDTO {
  
  private PaymentData paymentData;
  private String transactionIdentifier;
  
  public PaymentData getPaymentData() {
    return paymentData;
  }
  public void setPaymentData(PaymentData paymentData) {
    this.paymentData = paymentData;
  }
  public String getTransactionIdentifier() {
    return transactionIdentifier;
  }
  public void setTransactionIdentifier(String transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }

}
