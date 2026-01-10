import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class RSAKeyPairExample {

    public static void main(String[] args) throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair pair = gen.generateKeyPair();

        System.out.println("Public Key: " + pair.getPublic());
        System.out.println("Private Key: " + pair.getPrivate());
    }
}
