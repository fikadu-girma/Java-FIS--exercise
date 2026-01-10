public class InputValidation {

    public static boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z0-9_]{3,15}");
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("admin_123"));
        System.out.println(isValidUsername("admin';--"));
    }
}
