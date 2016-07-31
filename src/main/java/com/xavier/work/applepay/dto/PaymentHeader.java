package com.xavier.work.applepay.dto;

public class PaymentHeader extends BaseDTO {

  /**
   * SHA–256 hash, hex encoded as a string
   * Optional
   * Hash of the applicationData property of the original PKPaymentRequest object. 
   * If the value of that property is null, this key is omitted.
   */
  private String applicationData;
  
  /**
   * X.509 encoded key bytes, Base64 encoded as a string
   * Ephemeral public key bytes. EC_v1 only.
   */
  private String ephemeralPublicKey;
  
  /**
   * A Base64 encoded string.
   * The symmetric key wrapped using your RSA public key. RSA_v1 only.
   */
  private String wrappedKey;
  
  /**
   * SHA–256 hash, Base64 encoded as a string
   * Hash of the X.509 encoded public key bytes of the merchant’s certificate.
   */
  private String publicKeyHash;
  
  /**
   * hexadecimal identifier, as a string
   * Transaction identifier, generated on the device.
   */
  private String transactionId;

  public String getApplicationData() {
    return applicationData;
  }

  public void setApplicationData(String applicationData) {
    this.applicationData = applicationData;
  }

  public String getEphemeralPublicKey() {
    return ephemeralPublicKey;
  }

  public void setEphemeralPublicKey(String ephemeralPublicKey) {
    this.ephemeralPublicKey = ephemeralPublicKey;
  }

  public String getWrappedKey() {
    return wrappedKey;
  }

  public void setWrappedKey(String wrappedKey) {
    this.wrappedKey = wrappedKey;
  }

  public String getPublicKeyHash() {
    return publicKeyHash;
  }

  public void setPublicKeyHash(String publicKeyHash) {
    this.publicKeyHash = publicKeyHash;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }
  
}
