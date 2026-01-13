package Complecated;

public class SecureSandboxExecution {

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        try {
            System.exit(0);
        } catch (SecurityException e) {
            System.out.println("Operation blocked by security manager");
        }
    }
}
