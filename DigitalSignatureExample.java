import java.security.*;

public class DigitalSignatureExample {

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update("Important Data".getBytes());

        byte[] digitalSignature = signature.sign();
        System.out.println("Signature created");
    }
}
