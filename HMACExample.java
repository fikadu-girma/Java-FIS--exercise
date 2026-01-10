import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACExample {

    public static void main(String[] args) throws Exception {
        String secret = "sharedSecret";
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(), "HmacSHA256"));

        byte[] hmac = mac.doFinal("Message".getBytes());
        System.out.println(Base64.getEncoder().encodeToString(hmac));
    }
}
