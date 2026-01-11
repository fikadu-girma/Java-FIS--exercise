public class SecureConfigExample {

    public static void main(String[] args) {
        String apiKey = System.getenv("API_KEY");

        if (apiKey == null) {
            System.out.println("API key not configured");
        } else {
            System.out.println("API key loaded securely");
        }
    }
}
