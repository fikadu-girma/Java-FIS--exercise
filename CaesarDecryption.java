
import java.util.Scanner;

public class CaesarDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ciphertext: ");
        String ciphertext = scanner.nextLine();

        System.out.print("Enter the shift value (1-25): ");
        int shift = scanner.nextInt();

        String decryptedText = decrypt(ciphertext, shift);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char decryptedChar = (char) ((character - base + shift) % 26 + base);
                result.append(decryptedChar);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}