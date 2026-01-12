import java.security.SecureRandom;
import java.util.Base64;

public class SecureTokenGenerator {

    public static String generateToken() {
        byte[] bytes = new byte[32];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public static void main(String[] args) {
        System.out.println("Secure Token: " + generateToken());
    }
}
