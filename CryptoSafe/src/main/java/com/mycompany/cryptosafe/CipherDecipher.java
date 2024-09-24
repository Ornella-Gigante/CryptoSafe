/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cryptosafe;

import java.util.Scanner;



/**
 * Explanation:
 * - cipher: Converts each character of the string to its ASCII value, adds a key (integer value), 
 *   and then converts it back to a character.
 * - decipher: Performs the reverse process by subtracting the key from the ASCII value to recover the original character.
 * - showMenu: An interactive menu that allows the user to choose between ciphering, deciphering, or exiting the program.
 * 
 * Author: Ornella Gigante
 */
public class CipherDecipher {

    // Function to cipher the text with a numeric key
    public static String cipher(String text, int key) {
        StringBuilder cipheredText = new StringBuilder(); // Using StringBuilder to construct the ciphered text
        key = key % 95;  // Limit the key to the range of printable characters (95 characters from 32 to 126)

        // Iterate through each character of the original text
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);  // Get each character of the text
            int newAsciiValue = (int) character + key;  // Add the key to the ASCII value of the character

            // If the new ASCII value exceeds the printable range (greater than 126), adjust by subtracting 95
            if (newAsciiValue > 126) {
                newAsciiValue -= 95;
            }
            // Convert the new ASCII value to a character and append it to the ciphered text
            cipheredText.append((char) newAsciiValue);
        }
        // Return the ciphered text
        return cipheredText.toString();
    }

    // Function to decipher the text using the same key
    public static String decipher(String cipheredText, int key) {
        StringBuilder decipheredText = new StringBuilder(); // Using StringBuilder to construct the deciphered text
        key = key % 95;  // Limit the key to the range of printable characters

        // Iterate through each character of the ciphered text
        for (int i = 0; i < cipheredText.length(); i++) {
            char character = cipheredText.charAt(i);  // Get each character of the ciphered text
            int newAsciiValue = (int) character - key;  // Subtract the key from the ASCII value of the character

            // If the new ASCII value is less than the printable value (less than 32), adjust by adding 95
            if (newAsciiValue < 32) {
                newAsciiValue += 95;
            }
            // Convert the new ASCII value to a character and append it to the deciphered text
            decipheredText.append((char) newAsciiValue);
        }
        // Return the deciphered text
        return decipheredText.toString();
    }

    // Main method: the menu for interacting with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read user input

        while (true) {
            // Print the menu for the user to choose an option
            System.out.println("\n--- Message Encryption Program ---");
            System.out.println("1. Cipher message");
            System.out.println("2. Decipher message");
            System.out.println("3. Exit");
            System.out.print("Select one of the following options: ");
            String option = scanner.nextLine();  // Read the user's option

            // If the user selects the "Cipher message" option
            if (option.equals("1")) {
                System.out.print("Enter the text to cipher: ");
                String text = scanner.nextLine();  // Read the text to cipher
                System.out.print("Enter the numeric key for the ciphering: ");
                int key = scanner.nextInt();  // Read the numeric key
                scanner.nextLine();  // Clear the buffer to avoid issues in the next read

                String cipheredText = cipher(text, key);  // Call the cipher function
                System.out.println("\nOriginal text: " + text);
                System.out.println("Ciphered text: " + cipheredText);  // Display the ciphered text

            // If the user selects the "Decipher message" option
            } else if (option.equals("2")) {
                System.out.print("Enter the text to decipher: ");
                String cipheredText = scanner.nextLine();  // Read the ciphered text
                System.out.print("Enter the ciphering key: ");
                int key = scanner.nextInt();  // Read the numeric key
                scanner.nextLine();  // Clear the buffer to avoid issues in the next read

                String decipheredText = decipher(cipheredText, key);  // Call the decipher function
                System.out.println("\nCiphered text: " + cipheredText);
                System.out.println("Deciphered text: " + decipheredText);  // Display the deciphered text

            // If the user selects the "Exit" option
            } else if (option.equals("3")) {
                System.out.println("Exiting the program...");
                break;  // Break the loop to exit the program

            // If the user enters an invalid option
            } else {
                System.out.println("Incorrect. Please try again.");
            }
        }
        scanner.close();  // Close the Scanner when done
    }
}
