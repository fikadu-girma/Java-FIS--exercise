public class SecurityExceptionHandling {

    public static void main(String[] args) {
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            System.out.println("An error occurred. Please contact support.");
        }
    }
}
