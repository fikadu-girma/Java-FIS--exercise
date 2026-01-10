import java.security.SecureRandom;
import java.util.Base64;

public class PasswordSalting {

    public static String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static void main(String[] args) {
        System.out.println("Salt: " + generateSalt());
    }
}
