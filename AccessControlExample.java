public class AccessControlExample {

    static void accessResource(String role) {
        if ("ADMIN".equals(role)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }

    public static void main(String[] args) {
        accessResource("USER");
        accessResource("ADMIN");
    }
}
