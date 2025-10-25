
import java.util.Scanner;

public class CaesarEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter the shift value (1-25): ");
        int shift = scanner.nextInt();

        String encryptedText = encrypt(plaintext, shift);
        System.out.println("Encrypted Text: " + encryptedText);

        scanner.close();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) ((character - base + shift) % 26 + base);
                result.append(encryptedChar);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
