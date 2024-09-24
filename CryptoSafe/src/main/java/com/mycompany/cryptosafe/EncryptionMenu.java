package com.mycompany.cryptosafe;

import java.util.Scanner;
import javax.crypto.SecretKey;

/**
 * This class provides a menu-driven interface for selecting encryption options.
 * It allows users to choose between different encryption methods.
 * 
 * Author: Ornella Gigante
 */
public class EncryptionMenu {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); // Create a Scanner for user input

        while (true) {
            // Print the menu for the user to choose an option
            System.out.println("\n--- Encryption Program Menu ---");
            System.out.println("1. Cipher message");
            System.out.println("2. Decipher message");
            System.out.println("3. File Encryption (DES)");
            System.out.println("4. File Decryption (DES)");
            System.out.println("5. Asymmetric Encryption (RSA)");
            System.out.println("6. Exit");
            System.out.print("Select one of the following options: ");
            String option = scanner.nextLine(); // Read the user's option

            switch (option) {
                case "1" -> {
                    // Cipher a message
                    System.out.print("Enter the text to cipher: ");
                    String textToCipher = scanner.nextLine(); // Read the text to cipher
                    System.out.print("Enter the numeric key for the ciphering: ");
                    int cipherKey = scanner.nextInt(); // Read the numeric key
                    scanner.nextLine(); // Clear the buffer

                    String cipheredText = CipherDecipher.cipher(textToCipher, cipherKey); // Call the cipher method
                    System.out.println("Ciphered text: " + cipheredText); // Display the ciphered text
                }

                case "2" -> {
                    // Decipher a message
                    System.out.print("Enter the text to decipher: ");
                    String textToDecipher = scanner.nextLine(); // Read the text to decipher
                    System.out.print("Enter the ciphering key: ");
                    int decipherKey = scanner.nextInt(); // Read the numeric key
                    scanner.nextLine(); // Clear the buffer

                    String decipheredText = CipherDecipher.decipher(textToDecipher, decipherKey); // Call the decipher method
                    System.out.println("Deciphered text: " + decipheredText); // Display the deciphered text
                }

                case "3" -> {
                    // File Encryption
                    System.out.print("Enter the name of the file to encrypt: ");
                    String originalFile = scanner.nextLine(); // Read the name of the file to encrypt
                    SecretKey desKey = DESKeyGenerator.generateDESKey(); // Generate a DES key
                    DESKeyGenerator.saveKey(desKey, "desKey.key"); // Save the key to a file
                    String encryptedFile = originalFile + ".enc"; // Define the name of the encrypted file

                    FileEncryptionDES.cipherFile(originalFile, encryptedFile, desKey); // Call the method to cipher the file
                    System.out.println("File encrypted successfully: " + encryptedFile);
                }

                case "4" -> {
                    // File Decryption
                    System.out.print("Enter the name of the encrypted file to decrypt: ");
                    String fileToDecrypt = scanner.nextLine(); // Read the name of the file to decrypt
                    // Load the key from a file for decryption
                    SecretKey keyToDecrypt = DESKeyGenerator.loadKey("desKey.key"); // Load the key for decryption

                    FileEncryptionDES.decipherFile(fileToDecrypt, keyToDecrypt); // Call the method to decipher the file
                    System.out.println("File decrypted successfully: deciphered_" + fileToDecrypt);
                }

                case "5" -> {
                    // Asymmetric Encryption (RSA)
                    AsymmetricEncryption.main(args); // Directly call the main method of the AsymmetricEncryption class
                }

                case "6" -> {
                    // Exit the program
                    System.out.println("Exiting the program...");
                    scanner.close(); // Close the scanner when done
                    return; // Exit the loop and end the program
                }
                default -> // Handle invalid options
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
