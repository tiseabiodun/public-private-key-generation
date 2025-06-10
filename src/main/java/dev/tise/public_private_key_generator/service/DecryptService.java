package dev.tise.public_private_key_generator.service;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.util.Base64;

public class DecryptService {
    public static String decrypt(String encryptedString, PrivateKey privateKey) throws Exception{
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedString));
        return new String(decryptedBytes, "UTF-8");
    }
}
