public class SessionTimeoutExample {

    private static long sessionStartTime;
    private static final long SESSION_TIMEOUT = 5 * 60 * 1000;

    public static void startSession() {
        sessionStartTime = System.currentTimeMillis();
    }

    public static boolean isSessionValid() {
        return (System.currentTimeMillis() - sessionStartTime) < SESSION_TIMEOUT;
    }

    public static void main(String[] args) throws InterruptedException {
        startSession();
        System.out.println("Session valid: " + isSessionValid());
    }
}
