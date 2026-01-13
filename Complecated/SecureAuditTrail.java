package Complecated;

import java.security.MessageDigest;
import java.time.Instant;

public class SecureAuditTrail {

    private static String previousHash = "";

    public static void logEvent(String event) throws Exception {
        String record = Instant.now() + event + previousHash;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(record.getBytes());

        previousHash = bytesToHex(hash);
        System.out.println("Logged: " + event);
        System.out.println("Record Hash: " + previousHash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        logEvent("User login");
        logEvent("File accessed");
    }
}

