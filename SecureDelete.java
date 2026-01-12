import java.util.Arrays;

public class SecureDelete {

    public static void main(String[] args) {
        char[] password = "Secret123".toCharArray();

        System.out.println("Using password...");
        Arrays.fill(password, '\0');

        System.out.println("Password cleared from memory");
    }
}
