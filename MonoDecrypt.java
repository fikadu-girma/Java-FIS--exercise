
import java.util.Scanner;

public class MonoDecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = "XYZABCDEFGHIJKLMNOPQRSTUVW";

        System.out.print("Enter text to decrypt: ");
        String text = scanner.nextLine();

        String decrypted = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int pos = key.indexOf(ch);
                if (pos != -1) {
                    char original = (char) ('A' + pos);
                    decrypted += original;
                } else {
                    decrypted += ch;
                }
            }
            else if (ch >= 'a' && ch <= 'z') {
                char upperCh = Character.toUpperCase(ch);
                int pos = key.indexOf(upperCh);
                if (pos != -1) {
                    char original = (char) ('a' + pos);
                    decrypted += original;
                } else {
                    decrypted += ch;
                }
            }
            else {
                decrypted += ch;
            }
        }

        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}


