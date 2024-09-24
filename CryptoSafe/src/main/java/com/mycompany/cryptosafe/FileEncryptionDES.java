/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cryptosafe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * This class demonstrates file encryption and decryption using the DES algorithm.
 * It includes methods to generate a DES key, cipher a file, and decipher a file.
 * 
 * Author: Ornella Gigante
 */
public class FileEncryptionDES {

    // Method to generate a DES key
    public static SecretKey generateDESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56); // DES key size
        return keyGen.generateKey();
    }

    // Method to cipher the content of a file
    public static void cipherFile(String originalFile, String encryptedFile, SecretKey key) throws Exception {
        byte[] content = readFile(originalFile);
        
        // Configure the cipher to work in ENCRYPT mode
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        // Cipher the content
        byte[] encryptedContent = cipher.doFinal(content);
        
        // Save the encrypted content to a new file
        writeFile(encryptedFile, encryptedContent);
    }

    // Method to decipher the content of an encrypted file
    public static void decipherFile(String encryptedFile, SecretKey key) throws Exception {
        byte[] encryptedContent = readFile(encryptedFile);
        
        // Configure the cipher to work in DECRYPT mode
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        
        // Decipher the content
        byte[] originalContent = cipher.doFinal(encryptedContent);
        
        // Save the deciphered content to a new file
        writeFile("deciphered_" + encryptedFile, originalContent);
    }

    // Method to read the content of a file
    private static byte[] readFile(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] content = new byte[(int) file.length()]; // Create a byte array to hold the file content
        FileInputStream fis = new FileInputStream(file);
        fis.read(content); // Read the content into the byte array
        fis.close();
        return content; // Return the file content
    }

    // Method to write content to a file
    private static void writeFile(String fileName, byte[] content) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(content); // Write the byte array to the file
        fos.close();
    }

    // Main method for testing file encryption and decryption
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); // Create a Scanner for user input
        SecretKey key = generateDESKey(); // Generate a DES key

        System.out.print("Enter the path of the file to encrypt: ");
        String originalFile = scanner.nextLine(); // Read the name of the file to encrypt

        String encryptedFile = originalFile + ".enc"; // Define the name of the encrypted file

        // Call the method to cipher the file
        cipherFile(originalFile, encryptedFile, key);
        System.out.println("File encrypted successfully: " + encryptedFile);

        System.out.print("Enter the name of the encrypted file to decrypt: ");
        String fileToDecrypt = scanner.nextLine(); // Read the name of the file to decrypt

        // Call the method to decipher the file
        decipherFile(fileToDecrypt, key);
        System.out.println("File decrypted successfully: deciphered_" + fileToDecrypt);
        
        scanner.close(); // Close the scanner
    }
}
