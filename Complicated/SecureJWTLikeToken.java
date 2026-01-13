package Complicated;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SecureJWTLikeToken {

    private static final String SECRET = "superSecretKey";

    public static String sign(String payload) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(SECRET.getBytes(), "HmacSHA256"));
        byte[] sig = mac.doFinal(payload.getBytes());
        return payload + "." + Base64.getEncoder().encodeToString(sig);
    }

    public static boolean verify(String token) throws Exception {
        String[] parts = token.split("\\.");
        if (parts.length != 2) return false;
        return sign(parts[0]).equals(token);
    }

    public static void main(String[] args) throws Exception {
        String token = sign("user=admin");
        System.out.println("Valid token: " + verify(token));
    }
}
