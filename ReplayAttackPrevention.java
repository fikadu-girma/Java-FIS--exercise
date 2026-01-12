import java.util.UUID;

public class ReplayAttackPrevention {

    public static String generateNonce() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        String nonce = generateNonce();
        System.out.println("Request nonce: " + nonce);
    }
}
