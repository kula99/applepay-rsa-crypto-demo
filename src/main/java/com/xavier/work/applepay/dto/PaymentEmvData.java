package com.xavier.work.applepay.dto;

public class PaymentEmvData extends BaseDTO {

  /**
   * Output from the Secure Element.
   * EMV payment structure, Base64 encoded as a string
   */
  private String emvData;
  
  /**
   * The PIN is encrypted using the bank’s key. RSA_v1 only. 
   * The encrypted pin as a hex encoded string.
   */
  private String encryptedPINData;
  
  public String getEmvData() {
    return emvData;
  }
  public void setEmvData(String emvData) {
    this.emvData = emvData;
  }
  public String getEncryptedPINData() {
    return encryptedPINData;
  }
  public void setEncryptedPINData(String encryptedPINData) {
    this.encryptedPINData = encryptedPINData;
  }
}
