# 🔒 CryptoSafe: A Secure Encryption Tool 🔒

## CryptoSafe is a simple Java application designed for encrypting and decrypting messages and files using the DES and RSA algorithms. This project aims to provide a user-friendly menu interface to make cryptographic operations accessible for educational purposes and secure file handling.

### 🚀 Features

    Message Encryption/Decryption: Easily cipher and decipher text messages.
    File Encryption/Decryption: Securely encrypt and decrypt files with a simple command.
    Asymmetric Encryption: Use RSA for enhanced security.
    Key Generation: Generate secure keys for DES encryption.
    
### 📖 Table of Contents

    Installation
    Usage
    Classes Overview
    Flowchart
    Contributing
    License
    
# 🛠️ Installation


    Clone the repository:

    git clone https://github.com/Ornella-Gigante/CryptoSafe.git
    cd CryptoSafe
    Compile the project: Make sure you have Java Development Kit (JDK) installed. Then compile the project using:
    
    javac -d bin src/com/mycompany/cryptosafe/*.java
    Run the application:
    
    java -cp bin com.mycompany.cryptosafe.EncryptionMenu



### 📝 Usage

    Select an option from the menu:
    
    Cipher a message
    Decipher a message
    File Encryption (DES)
    File Decryption (DES)
    Asymmetric Encryption (RSA)
    Exit
    Follow the prompts for inputting text, files, and keys.


### 📚 Classes Overview
    
    
    1. EncryptionMenu
    Purpose: Provides a menu-driven interface for users to select different encryption options.
    Key Functions:
    Display options for message and file encryption/decryption.
    Handle user input and call the appropriate methods for encryption tasks.
    2. CipherDecipher
    Purpose: Contains methods for ciphering and deciphering text messages.
    Key Functions:
    cipher(String text, int key): Encrypts the input text using a numeric key.
    decipher(String text, int key): Decrypts the input text using the same numeric key.
    3. FileEncryptionDES
    Purpose: Handles file encryption and decryption using the DES algorithm.
    Key Functions:
    cipherFile(String inputFile, String outputFile, SecretKey key): Encrypts the specified file and saves the result.
    decipherFile(String inputFile, SecretKey key): Decrypts the specified file using the given key.
    4. DESKeyGenerator
    Purpose: Generates secure DES keys for file encryption.
    Key Functions:
    generateDESKey(): Creates and returns a new DES key.
    5. AsymmetricEncryption
    Purpose: Provides methods for asymmetric encryption using RSA.

    
### Key Functions:


    Contains functionality for generating RSA keys and encrypting/decrypting messages.

### 🔄 Flowchart
    
    +-------------------------+
    |      Start Program      |
    +-------------------------+
                |
                v
    +-------------------------+
    |    Display Main Menu    |
    +-------------------------+
    |  1. Cipher message      |
    |  2. Decipher message    |
    |  3. File Encryption (DES)|
    |  4. File Decryption (DES)|
    |  5. Asymmetric Encryption|
    |  6. Exit                |
    +-------------------------+
                |
                v
    +--------------------------+
    | User selects an option   |
    +--------------------------+
                |
                v
    +-------------------------+
    |  Option 1: Cipher a     |
    |       message           |
    +-------------------------+
                |
                v
    +-------------------------+
    | Input text to cipher    |
    +-------------------------+
                |
                v
    +-------------------------+
    | Input numeric key       |
    +-------------------------+
                |
                v
    +------------------------------+
    | Call CipherDecipher.cipher() |
    +------------------------------+
                |
                v
    +-------------------------+
    | Display ciphered text   |
    +-------------------------+
                |
                v
    +-------------------------+
    |     Return to Main Menu |
    +-------------------------+
    
                |
                v
    +-------------------------+
    |  Option 2: Decipher a   |
    |       message           |
    +-------------------------+
                |
                v
    +-------------------------+
    | Input text to decipher   |
    +-------------------------+
                |
                v
    +-------------------------+
    | Input numeric key        |
    +-------------------------+
                |
                v
    +-------------------------------+
    | Call CipherDecipher.decipher()|
    +-------------------------------+
                |
                v
    +-------------------------+
    | Display deciphered text  |
    +-------------------------+
                |
                v
    +-------------------------+
    |     Return to Main Menu  |
    +-------------------------+
    
                |
                v
    +-------------------------+
    | Option 3: File          |
    | Encryption (DES)        |
    +-------------------------+
                |
                v
    +-------------------------+
    | Input name of file to   |
    | encrypt                 |
    +-------------------------+
                |
                v
    +---------------------------------+
    | Generate DES key using          |
    | DESKeyGenerator.generateDESKey()|
    +---------------------------------+
                |
                v
    +------------------------------------+
    | Call FileEncryptionDES.cipherFile()|
    +----------------------...........---+
                |
                v
    +-------------------------+
    | Display success message  |
    +-------------------------+
                |
                v
    +-------------------------+
    |     Return to Main Menu  |
    +-------------------------+
    
                |
                v
    +-------------------------+
    | Option 4: File          |
    | Decryption (DES)        |
    +-------------------------+
                |
                v
    +-------------------------+
    | Input name of file to   |
    | decrypt                 |
    +-------------------------+
                |
                v
    +-------------------------+
    | Input DES key for       |
    | decryption (original key) |
    +-------------------------+
                |
                v
    +--------------------------------------+
    | Call FileEncryptionDES.decipherFile()|
    +--------------------------------------+
                |
                v
    +-------------------------+
    | Display success message  |
    +-------------------------+
                |
                v
    +-------------------------+
    |     Return to Main Menu  |
    +-------------------------+
    
                |
                v
    +-------------------------+
    | Option 5: Asymmetric    |
    | Encryption (RSA)        |
    +-------------------------+
                |
                v
    +----------------------------------+
    | Call AsymmetricEncryption.main() |
    +----------------------------------+
                |
                v
    +-------------------------+
    |     Return to Main Menu  |
    +-------------------------+
    
                |
                v
    +-------------------------+
    | Option 6: Exit          |
    +-------------------------+
                |
                v
    +-------------------------+
    |     Close Program       |
    +-------------------------+
    


### 🤝 Contributing
### Contributions are welcome! Please feel free to submit issues or pull requests.

    Steps to contribute:
    Fork the repository.
    Create your feature branch: git checkout -b feature/YourFeature
    Commit your changes: git commit -m 'Add some feature'
    Push to the branch: git push origin feature/YourFeature
    Open a Pull Request.

    
### 📄 License
### This project is licensed under the MIT License - see the LICENSE file for details.


### 📫 Contact

    For any questions or suggestions, feel free to reach out to me:
    
    LinkedIn: https://www.linkedin.com/in/ornella-gigante/
    Email: ornella-gigante@hotmail.com.ar


###📽️ DEMO 

[Demo](https://github.com/Ornella-Gigante/CryptoSafe/blob/main/CRYTOFUN.mkv)
