package Noted.zhang8_IOStream.字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteIOStream {
    public static void main(String[] args) {
        outputStream();
        inputStream();
    }

    public static void inputStream() {
        try (FileInputStream fis = new FileInputStream("src/aaa/a.txt");) {
            byte[] bys = new byte[1024];
            int len;
            while ((len = fis.read(bys)) != -1) {
                System.out.println(new String(bys, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void outputStream() {
        try (FileOutputStream fos = new FileOutputStream("src/aaa/a.txt")) {
            fos.write("abcdefgh".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
