import java.io.*;

public class SecureDeserialization {

    static class SafeObject implements Serializable {
        String data = "Safe Data";
    }

    public static void main(String[] args) throws Exception {
        SafeObject obj = new SafeObject();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(obj);

        ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(bos.toByteArray())
        );

        Object readObj = in.readObject();
        System.out.println(readObj.getClass().getName());
    }
}
