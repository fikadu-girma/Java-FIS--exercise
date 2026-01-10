import java.io.File;
import java.io.IOException;

public class SecureFileRead {

    public static void readFile(String baseDir, String fileName) throws IOException {
        File base = new File(baseDir).getCanonicalFile();
        File file = new File(base, fileName).getCanonicalFile();

        if (!file.getPath().startsWith(base.getPath())) {
            throw new SecurityException("Path traversal attempt detected!");
        }

        System.out.println("Safe file path: " + file.getPath());
    }

    public static void main(String[] args) throws Exception {
        readFile("/safe/data", "example.txt");
    }
}
