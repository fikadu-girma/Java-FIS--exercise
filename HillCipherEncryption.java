
import java.util.Scanner;

public class HillCipherEncryption {

    static int mod26(int x) {
        return (x % 26 + 26) % 26;
    }

    static int[] encrypt(int[][] keyMatrix, int[] messageVector, int n) {
        int[] cipherVector = new int[n];
        for (int i = 0; i < n; i++) {
            cipherVector[i] = 0;
            for (int j = 0; j < n; j++) {
                cipherVector[i] += keyMatrix[i][j] * messageVector[j];
            }
            cipherVector[i] = mod26(cipherVector[i]);
        }
        return cipherVector;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Hill Cipher Encryption =====");
        System.out.print("Enter message: ");
        String message = sc.nextLine().toLowerCase().replaceAll("[^a-z]", "");

        int n = 2;
        int[][] keyMatrix = new int[n][n];

        System.out.println("Enter 2x2 key matrix (only integers 0–25):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                keyMatrix[i][j] = sc.nextInt();

        if (message.length() % n != 0) {
            message += "x";
        }

        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < message.length(); i += n) {
            int[] messageVector = new int[n];
            for (int j = 0; j < n; j++)
                messageVector[j] = message.charAt(i + j) - 'a';

            int[] cipherVector = encrypt(keyMatrix, messageVector, n);
            for (int val : cipherVector)
                cipherText.append((char) (val + 'a'));
        }

        System.out.println("Encrypted Text: " + cipherText);
        sc.close();
    }
}


