public class HTTPSCheck {

    public static boolean isSecureURL(String url) {
        return url.startsWith("https://");
    }

    public static void main(String[] args) {
        System.out.println(isSecureURL("http://example.com"));
        System.out.println(isSecureURL("https://example.com"));
    }
}
