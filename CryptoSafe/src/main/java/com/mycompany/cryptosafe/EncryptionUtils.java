/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cryptosafe;


/**
 * This class contains utility methods used across various encryption classes.
 * 
 * Author: Ornella Gigante
 */
public class EncryptionUtils {

    // Method to convert a byte array to its hexadecimal representation
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            // Format each byte to a two-digit hexadecimal string
            sb.append(String.format("%02x", b));
        }
        return sb.toString(); // Return the hexadecimal string
    }
}
