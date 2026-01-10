import java.security.SecureRandom;

public class SecureRandomExample {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        int value = random.nextInt(1000);
        System.out.println("Secure Random Number: " + value);
    }
}
