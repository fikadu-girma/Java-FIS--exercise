import java.util.HashMap;
import java.util.Map;

public class LoginAttemptLimiter {

    private static final int MAX_ATTEMPTS = 3;
    private static Map<String, Integer> attempts = new HashMap<>();

    public static boolean login(String user, String password) {
        attempts.putIfAbsent(user, 0);

        if (attempts.get(user) >= MAX_ATTEMPTS) {
            System.out.println("Account locked!");
            return false;
        }

        if ("admin".equals(user) && "password".equals(password)) {
            attempts.put(user, 0);
            return true;
        }

        attempts.put(user, attempts.get(user) + 1);
        return false;
    }

    public static void main(String[] args) {
        login("admin", "wrong");
        login("admin", "wrong");
        login("admin", "wrong");
        login("admin", "password");
    }
}
