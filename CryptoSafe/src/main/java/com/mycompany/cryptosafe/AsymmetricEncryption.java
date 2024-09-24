/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cryptosafe;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.PrivateKey;
import javax.crypto.Cipher;

/**
 * This class demonstrates asymmetric encryption using RSA.
 * It generates a key pair (public and private) and allows the user 
 * to encrypt and decrypt a message using these keys.
 * 
 * Author: Ornella Gigante
 */
public class AsymmetricEncryption {

    public static void main(String[] args) throws Exception {
        // Generate a pair of keys (public and private)
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);  // Define the key size to 2048 bits, which is considered secure
        
        // Generate the key pair, which includes both public and private keys
        KeyPair keyPair = keyGen.generateKeyPair();
        
        // Extract the public key and private key from the generated pair
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Define the message to be encrypted
        String originalMessage = "This is a secret message";

        // Encrypt the message using the public key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        // Perform the encryption of the original message
        byte[] encryptedMessage = cipher.doFinal(originalMessage.getBytes());
        
        // Print the encrypted message in hexadecimal format for better visualization
        System.out.println("Encrypted message: " + bytesToHex(encryptedMessage));

        // Now decrypt the encrypted message using the private key
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        
        // Decrypt the encrypted message
        byte[] decryptedMessage = cipher.doFinal(encryptedMessage);
        
        // Finally, print the decrypted message by converting the byte array back to String
        System.out.println("Decrypted message: " + new String(decryptedMessage));
    }

    // Auxiliary method that converts a byte array to its hexadecimal representation
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            // Format each byte to a two-digit hexadecimal string
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
