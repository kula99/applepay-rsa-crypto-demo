package com.xavier.work.applepay.dto;

public class PaymentData extends BaseDTO {
  
  /**
   * payment data dictionary, Base64 encoded as a string
   * Encrypted payment data.
   */
  private String data;
  
  /**
   * header dictionary
   * Additional version-dependent information used to decrypt and verify the payment.
   */
  private PaymentHeader header;
  
  /**
   * detached PKCS #7 signature, Base64 encoded as string
   * Signature of the payment and header data. 
   * The signature includes the signing certificate, its intermediate CA certificate, 
   * and information about the signing algorithm.
   */
  private String signature;

  /**
   * Version information about the payment token.
   * The token uses EC_v1 for ECC-encrypted data, and RSA_v1 for RSA-encrypted data.
   */
  private String version;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public PaymentHeader getHeader() {
    return header;
  }

  public void setHeader(PaymentHeader header) {
    this.header = header;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}
