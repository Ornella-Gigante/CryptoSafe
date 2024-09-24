package com.mycompany.cryptosafe;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * This class is responsible for generating a DES key.
 * It can be used independently to create and retrieve a new DES key.
 * 
 * Author: Ornella Gigante
 */
public class DESKeyGenerator {

    // Method to generate a DES key
    public static SecretKey generateDESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56); // DES key size
        return keyGen.generateKey(); // Return the generated key
    }

    // Method to save the key to a file
    public static void saveKey(SecretKey key, String filename) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(key);
        }
    }

    // Method to load the key from a file
    public static SecretKey loadKey(String filename) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (SecretKey) ois.readObject();
        }
    }

    // Main method to demonstrate key generation
    public static void main(String[] args) {
        try {
            SecretKey key = generateDESKey(); // Generate a DES key
            saveKey(key, "desKey.key"); // Save the key to a file
            System.out.println("Generated and saved DES Key: " + key); // Print the generated key
        } catch (Exception e) {
            // Print any exceptions

        }
    }
}

