Apple Pay RSA crpyto demo
---

这是一个关于Apple Pay In-App购买RSA格式解密实现的demo程序，关于payment token的格式、验签、解密的说明可以参考Apple官方文档：[Payment Token Format Reference](https://developer.apple.com/library/ios/documentation/PassKit/Reference/PaymentTokenJSON/PaymentTokenJSON.html)

加密的测试数据（出于安全考虑，这里只贴出了数据格式，不是完整数据）

```
{
    "version": "RSA_v1",
    "data": "5oHg6cr67/UOf9HLrBJwmJLP/Kbx0sbitKDnbHc28xcBaiEYHFyiwYJW5Llex.....",
    "signature": "MIAGCSqGSIb3DQEHAqCAMIACAQExDzANBglghkgBZQMEAgEFADCABgkqhkiG9w0BBwEAAKCAMIIEtTCCBFugAwIBAgIIEVmL4CjCUF8wCgYIKoZIzj0EAwI.....",
    "header": {
        "publicKeyHash": "oJURN3WmP5aM6Gjlki3CWLUp9Rj......",
        "transactionId": "08510a448242990......",
        "wrappedKey": "0q1RecEDrksbSkbqyHHb8Mm7UsaxInGJYCGV/7PYH505lVB+6BFLfwYY6gjnq8lz5......"
    }
}
```

解密`data`的数据

```
{
    applicationPrimaryAccountNumber: "6258020xxxxxxxxx",
    applicationExpirationDate: "260101",
    currencyCode: "156",
    transactionAmount: 0,
    deviceManufacturerIdentifier: "062010030xxx",
    paymentDataType: "EMV",
    paymentData: {
        emvData: "nyYI3ThbugtzaFqfNgIABoECADuDgYi....."
    }
}

```

#### 其他参考

1、签名验证：[Apple-Pay-Signature-Verification](https://github.com/Zooz/Apple-Pay-Signature-Verification)

2、ECC格式解密：[applepay_crypto_demo](https://github.com/beatty/applepay_crypto_demo)


---

### English version

This is a demo implementation of Apple Pay In-App payment cryto, according to [Payment Token Format Reference](https://developer.apple.com/library/ios/documentation/PassKit/Reference/PaymentTokenJSON/PaymentTokenJSON.html)

This program turns the 'data' element from this JSON(some characters are removed for security)

```
{
    "version": "RSA_v1",
    "data": "5oHg6cr67/UOf9HLrBJwmJLP/Kbx0sbitKDnbHc28xcBaiEYHFyiwYJW5Llex.....",
    "signature": "MIAGCSqGSIb3DQEHAqCAMIACAQExDzANBglghkgBZQMEAgEFADCABgkqhkiG9w0BBwEAAKCAMIIEtTCCBFugAwIBAgIIEVmL4CjCUF8wCgYIKoZIzj0EAwI.....",
    "header": {
        "publicKeyHash": "oJURN3WmP5aM6Gjlki3CWLUp9Rj......",
        "transactionId": "08510a448242990......",
        "wrappedKey": "0q1RecEDrksbSkbqyHHb8Mm7UsaxInGJYCGV/7PYH505lVB+6BFLfwYY6gjnq8lz5......"
    }
}
```

Into this

```
{
    applicationPrimaryAccountNumber: "6258020xxxxxxxxx",
    applicationExpirationDate: "260101",
    currencyCode: "156",
    transactionAmount: 0,
    deviceManufacturerIdentifier: "062010030xxx",
    paymentDataType: "EMV",
    paymentData: {
        emvData: "nyYI3ThbugtzaFqfNgIABoECADuDgYi....."
    }
}
```

#### Other demos

1、Signature verification: [Apple-Pay-Signature-Verification](https://github.com/Zooz/Apple-Pay-Signature-Verification)

2、ECC type decryption: [applepay_crypto_demo](https://github.com/beatty/applepay_crypto_demo)
