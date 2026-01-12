import java.util.Random;

public class TwoFactorAuthSimulation {

    public static int generateOTP() {
        return 100000 + new Random().nextInt(900000);
    }

    public static void main(String[] args) {
        int otp = generateOTP();
        System.out.println("Generated OTP: " + otp);
        System.out.println("OTP valid for short time only");
    }
}
