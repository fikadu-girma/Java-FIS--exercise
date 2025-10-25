
import java.util.Scanner;

public class MonoEncrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = "XYZABCDEFGHIJKLMNOPQRSTUVW";

        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();

        String encrypted = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int pos = ch - 'A';       
                char encryptedChar = key.charAt(pos);
                encrypted += encryptedChar;
            }
            else if (ch >= 'a' && ch <= 'z') {
                int pos = ch - 'a';       
                char encryptedChar = key.charAt(pos);
                encryptedChar = Character.toLowerCase(encryptedChar);
                encrypted += encryptedChar;
            }
            else {
                encrypted += ch;
            }
        }

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Key used : " + key);

        scanner.close();
    }
}