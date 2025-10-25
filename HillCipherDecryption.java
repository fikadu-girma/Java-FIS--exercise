
import java.util.Scanner;

public class HillCipherDecryption {

    static int mod26(int x) {
        return (x % 26 + 26) % 26;
    }

    static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1)
                return x;
        }
        return -1;
    }

    static int[][] inverseMatrix(int[][] keyMatrix) {
        int det = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        det = mod26(det);
        int invDet = modInverse(det, 26);

        int[][] inv = new int[2][2];
        inv[0][0] = mod26(keyMatrix[1][1] * invDet);
        inv[0][1] = mod26(-keyMatrix[0][1] * invDet);
        inv[1][0] = mod26(-keyMatrix[1][0] * invDet);
        inv[1][1] = mod26(keyMatrix[0][0] * invDet);

        return inv;
    }

    static int[] decrypt(int[][] invKey, int[] cipherVector, int n) {
        int[] messageVector = new int[n];
        for (int i = 0; i < n; i++) {
            messageVector[i] = 0;
            for (int j = 0; j < n; j++) {
                messageVector[i] += invKey[i][j] * cipherVector[j];
            }
            messageVector[i] = mod26(messageVector[i]);
        }
        return messageVector;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Hill Cipher Decryption =====");
        System.out.print("Enter cipher text: ");
        String cipherText = sc.nextLine().toLowerCase().replaceAll("[^a-z]", "");

        int n = 2;
        int[][] keyMatrix = new int[n][n];

        System.out.println("Enter the same 2x2 key matrix used for encryption:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                keyMatrix[i][j] = sc.nextInt();

        int[][] invKey = inverseMatrix(keyMatrix);
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i += n) {
            int[] cipherVector = new int[n];
            for (int j = 0; j < n; j++)
                cipherVector[j] = cipherText.charAt(i + j) - 'a';

            int[] messageVector = decrypt(invKey, cipherVector, n);
            for (int val : messageVector)
                decryptedText.append((char) (val + 'a'));
        }

        System.out.println("Decrypted Text: " + decryptedText);
        sc.close();
    }
}



