/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cryptosafe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class handles reading from and writing to files.
 * It provides utility methods for file operations.
 * 
 * Author: Ornella Gigante
 */
public class FileHandler {

    // Method to read the content of a file
    public static byte[] readFile(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] content = new byte[(int) file.length()]; // Create a byte array to hold the file content
        FileInputStream fis = new FileInputStream(file);
        fis.read(content); // Read the content into the byte array
        fis.close();
        return content; // Return the file content
    }

    // Method to write content to a file
    public static void writeFile(String fileName, byte[] content) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(content); // Write the byte array to the file
        fos.close();
    }
}
