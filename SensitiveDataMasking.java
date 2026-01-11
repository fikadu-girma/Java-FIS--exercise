public class SensitiveDataMasking {

    public static String maskCardNumber(String card) {
        return "**** **** **** " + card.substring(card.length() - 4);
    }

    public static void main(String[] args) {
        System.out.println(maskCardNumber("1234567812345678"));
    }
}
