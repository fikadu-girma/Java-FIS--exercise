public class PasswordStrengthChecker {

    public static boolean isStrong(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[@#$%!].*");
    }

    public static void main(String[] args) {
        System.out.println(isStrong("Weak123"));
        System.out.println(isStrong("Strong@123"));
    }
}
