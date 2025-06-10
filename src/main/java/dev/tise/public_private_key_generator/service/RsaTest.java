package dev.tise.public_private_key_generator.service;

import java.security.*;

public class RsaTest {
    public static void main(String[] args) {
        try{
            KeyPair keyPair = RsaKeyUtil.generateKeyPair();

            RsaKeyUtil.saveKeyToPemFile("public.key", keyPair.getPublic(), "PUBLIC");
            RsaKeyUtil.saveKeyToPemFile("private.key", keyPair.getPrivate(), "PRIVATE");

            String text = "Hello, World";
            System.err.println("Original text: " + text);

            String encrypted = EncryptService.encrypt(text, keyPair.getPublic());
            System.err.println("Encrypted: " +encrypted);

            String decrypted = DecryptService.decrypt(encrypted, keyPair.getPrivate());
            System.err.println("Decrypted: "+decrypted);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
