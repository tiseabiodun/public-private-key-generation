package dev.tise.public_private_key_generator.service;

import javax.crypto.Cipher;
import java.security.PublicKey;
import java.util.Base64;

public class EncryptService {
    public static String encrypt(String text, PublicKey publicKey) throws Exception{
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] cipherText = encryptCipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(cipherText);
    }
}
