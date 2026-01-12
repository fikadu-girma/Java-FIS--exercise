import java.time.Instant;

public class RateLimitingExample {

    private static int requestCount = 0;
    private static long windowStart = Instant.now().getEpochSecond();

    public static boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        if (now - windowStart > 10) {
            windowStart = now;
            requestCount = 0;
        }
        return ++requestCount <= 5;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println("Allowed: " + allowRequest());
        }
    }
}
