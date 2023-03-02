package com.danilbel.cryptosystem.ciphers.symmetric;

public class CeasarCipher implements ISymmetricCipher {
    @Override
    public String encrypt(String message, int key) {
        return cipher(message, key);
    }

    @Override
    public String decrypt(String message, int key) {
        return cipher(message, -key);
    }

    @Override
    public String cipher(String message, int key) {
        StringBuilder cripted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            cripted.append((char) (message.charAt(i) + key));
        }
        return cripted.toString();
    }

    public String bruteForce(String message, int minKey, int maxKey) {
        if (message.length() > 30) {
            message = message.substring(0, 30);
        }
        StringBuilder result = new StringBuilder();
        for (int i = minKey; i <= maxKey; i++) {
            result.append("--- Key: ").append(i).append(" ---\n").append(decrypt(message, i)).append("...\n\n");
        }
        return result.toString();
    }
}


