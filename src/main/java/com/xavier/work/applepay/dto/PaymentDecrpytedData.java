package com.xavier.work.applepay.dto;

public class PaymentDecrpytedData extends BaseDTO {
  
  /**
   * Device-specific account number of the card that funds this transaction.
   */
  private String applicationPrimaryAccountNumber;
  
  /**
   * Card expiration date in the format YYMMDD.
   */
  private String applicationExpirationDate;
  
  /**
   * ISO 4217 numeric currency code, as a string to preserve leading zeros.
   */
  private String currencyCode;
  
  /**
   * Transaction amount. 
   */
  private String transactionAmount;
  
  /**
   * Optional. Cardholder name.
   */
  private String cardholderName;
  
  /**
   * Hex-encoded device manufacturer identifier.
   */
  private String deviceManufacturerIdentifier;
  
  /**
   * Either 3DSecure or EMV.
   */
  private String paymentDataType;
  
  /**
   * Detailed payment data. Dictionary
   */
  private PaymentEmvData paymentData;
  
  public String getApplicationPrimaryAccountNumber() {
    return applicationPrimaryAccountNumber;
  }
  public void setApplicationPrimaryAccountNumber(String applicationPrimaryAccountNumber) {
    this.applicationPrimaryAccountNumber = applicationPrimaryAccountNumber;
  }
  public String getApplicationExpirationDate() {
    return applicationExpirationDate;
  }
  public void setApplicationExpirationDate(String applicationExpirationDate) {
    this.applicationExpirationDate = applicationExpirationDate;
  }
  public String getCurrencyCode() {
    return currencyCode;
  }
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }
  public String getTransactionAmount() {
    return transactionAmount;
  }
  public void setTransactionAmount(String transactionAmount) {
    this.transactionAmount = transactionAmount;
  }
  public String getCardholderName() {
    return cardholderName;
  }
  public void setCardholderName(String cardholderName) {
    this.cardholderName = cardholderName;
  }
  public String getDeviceManufacturerIdentifier() {
    return deviceManufacturerIdentifier;
  }
  public void setDeviceManufacturerIdentifier(String deviceManufacturerIdentifier) {
    this.deviceManufacturerIdentifier = deviceManufacturerIdentifier;
  }
  public String getPaymentDataType() {
    return paymentDataType;
  }
  public void setPaymentDataType(String paymentDataType) {
    this.paymentDataType = paymentDataType;
  }
  public PaymentEmvData getPaymentData() {
    return paymentData;
  }
  public void setPaymentData(PaymentEmvData paymentData) {
    this.paymentData = paymentData;
  }

}
