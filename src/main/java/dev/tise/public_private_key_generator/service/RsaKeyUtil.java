package dev.tise.public_private_key_generator.service;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class RsaKeyUtil {
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException{
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");

        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    public static void saveKeyToPemFile(String filename, Key key, String keyType) throws IOException{
        String encodedKey = Base64.getMimeEncoder(64, new byte[]{'\n'}).encodeToString(key.getEncoded());
        String pem = "-----BEGIN " + keyType + "KEY-----\n" +
                encodedKey + "\n" +
                "-----END" + keyType + "KEY-----";



        try(FileWriter fw = new FileWriter(filename)){
            fw.write(pem);
        }
    }
}
