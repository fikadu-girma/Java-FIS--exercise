import java.io.File;

public class FilePermissionCheck {

    public static void main(String[] args) {
        File file = new File("data.txt");

        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Executable: " + file.canExecute());
    }
}
