
import java.util.Scanner;

public class HillCipher {
    // Alphabet for mapping: A=0, B=1..., Z=25
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Encrypts the text using a 2x2 key matrix
    public static String encrypt(String text, int[][] key) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder result = new StringBuilder();
        
        // Process text in blocks of 2 letters
        for (int i = 0; i < text.length(); i += 2) {
            int p1 = ALPHABET.indexOf(text.charAt(i));
            int p2 = (i + 1 < text.length()) ? ALPHABET.indexOf(text.charAt(i + 1)) : 0;

            int c1 = (key[0][0] * p1 + key[0][1] * p2) % 26;
            int c2 = (key[1][0] * p1 + key[1][1] * p2) % 26;

            result.append(ALPHABET.charAt(c1));
            result.append(ALPHABET.charAt(c2));
        }
        return result.toString();
    }

    // Finds modular inverse of a number modulo 26
    private static int modInverse(int a) {
        a = a % 26;
        for (int x = 1; x < 26; x++) {
            if ((a * x) % 26 == 1) {
                return x;
            }
        }
        return -1;
    }

    // Decrypts the text using the inverse of the 2x2 key matrix
    public static String decrypt(String text, int[][] key) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder result = new StringBuilder();

        int a = key[0][0], b = key[0][1], c = key[1][0], d = key[1][1];
        int det = (a * d - b * c) % 26;
        if (det < 0) det += 26;

        // Find modular inverse of determinant
        int detInv = modInverse(det);
        if (detInv == -1) {
            return "Error: Key matrix is not invertible!";
        }

        // Inverse matrix: [[d, -b], [-c, a]] * detInv mod 26
        int[][] invKey = new int[2][2];
        invKey[0][0] = (d * detInv) % 26;
        invKey[0][1] = ((-b * detInv) % 26 + 26) % 26;
        invKey[1][0] = ((-c * detInv) % 26 + 26) % 26;
        invKey[1][1] = (a * detInv) % 26;

        // Decrypt using inverse matrix
        for (int i = 0; i < text.length(); i += 2) {
            int c1 = ALPHABET.indexOf(text.charAt(i));
            int c2 = (i + 1 < text.length()) ? ALPHABET.indexOf(text.charAt(i + 1)) : 0;

            // Matrix multiplication: [p1, p2] = invKey * [c1, c2]
            int p1 = (invKey[0][0] * c1 + invKey[0][1] * c2) % 26;
            int p2 = (invKey[1][0] * c1 + invKey[1][1] * c2) % 26;

            result.append(ALPHABET.charAt(p1));
            result.append(ALPHABET.charAt(p2));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get plaintext from user
        System.out.print("Enter text to encrypt (only letters, even length): ");
        String text = scanner.nextLine();

        // Get 2x2 key matrix from user
        int[][] key = new int[2][2];
        System.out.println("Enter 2x2 key matrix (4 numbers, e.g., 1 2 3 4):");
        key[0][0] = scanner.nextInt();
        key[0][1] = scanner.nextInt();
        key[1][0] = scanner.nextInt();
        key[1][1] = scanner.nextInt();

        // Encrypt
        String encrypted = encrypt(text, key);
        System.out.println("Encrypted: " + encrypted);

        // Decrypt
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}



