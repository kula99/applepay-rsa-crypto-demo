package com.xavier.work.applepay.crypto;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ApplePayCryptoUtil {
  
  // Apple Pay uses an 0s for the IV(initialization vector)
  private static final byte[] IV = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
  
  /**
   * Restore the symmetric key
   * For RSA (RSA_v1), the symmetric key is encrypted by a merchant’s public key using the RSA/ECB/OAEPWithSHA256AndMGF1Padding algorithm. 
   * Use your RSA private key to decrypt the wrapped key blob and access the symmetric key.
   * 
   * @param wrappedKeyBytes
   * @param privKey
   * @return
   * @throws IOException
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   * @throws NoSuchPaddingException
   * @throws InvalidKeyException
   * @throws InvalidAlgorithmParameterException
   * @throws IllegalBlockSizeException
   * @throws BadPaddingException
   */
  public static byte[] restoreSymmetricKey(byte[] wrappedKeyBytes, byte[] privKey)
      throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
      InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException,
      BadPaddingException {
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privKey);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", new BouncyCastleProvider());
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    return cipher.doFinal(wrappedKeyBytes);
  }
  
  /**
   * Use the symmetric key to decrypt the value of the data key.
   * For RSA (RSA_v1), Decrypt the data key using AES–128 (id-aes128-GCM 2.16.840.1.101.3.4.1.6), 
   * with an initialization vector of 16 null bytes and no associated authentication data.
   * 
   * @param symmetricKeyBytes
   * @param dataBytes
   * @return
   * @throws NoSuchAlgorithmException
   * @throws NoSuchPaddingException
   * @throws InvalidKeyException
   * @throws IllegalBlockSizeException
   * @throws BadPaddingException
   * @throws InvalidAlgorithmParameterException
   */
  public static byte[] decryptData(byte[] symmetricKeyBytes, byte[] dataBytes)
      throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
      IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
    SecretKeySpec secretKeySpec = new SecretKeySpec(symmetricKeyBytes, "AES");
//    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding"); // this line works fine in JDK8
    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", new BouncyCastleProvider());
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new GCMParameterSpec(128, IV));
    return cipher.doFinal(dataBytes);
  }

}
