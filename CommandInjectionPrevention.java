public class CommandInjectionPrevention {

    public static void main(String[] args) {
        String userInput = "example.txt";

        if (!userInput.matches("[a-zA-Z0-9._-]+")) {
            throw new SecurityException("Invalid input");
        }

        System.out.println("Safe command argument: " + userInput);
    }
}
