package Complicated;
import javax.crypto.*;
import java.io.*;
import java.security.SecureRandom;

public class SecureFileEncryption {

    public static void encryptFile(File input, File output, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(input);
             FileOutputStream fos = new FileOutputStream(output);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {

            fis.transferTo(cos);
        }
    }

    public static void main(String[] args) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128, new SecureRandom());
        SecretKey key = kg.generateKey();

        encryptFile(new File("plain.txt"), new File("encrypted.bin"), key);
        System.out.println("File encrypted");
    }
}
