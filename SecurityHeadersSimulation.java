public class SecurityHeadersSimulation {

    public static void main(String[] args) {
        System.out.println("X-Content-Type-Options: nosniff");
        System.out.println("X-Frame-Options: DENY");
        System.out.println("Content-Security-Policy: default-src 'self'");
    }
}
