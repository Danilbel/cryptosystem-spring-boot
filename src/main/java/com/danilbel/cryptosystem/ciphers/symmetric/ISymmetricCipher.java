package com.danilbel.cryptosystem.ciphers.symmetric;

public interface ISymmetricCipher {
    String encrypt(String message, int key);
    String decrypt(String message, int key);
    String cipher(String message, int key);
}

