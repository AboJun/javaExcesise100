package Noted.zhang8_IOStream.SequenceInputStream序列化流;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * 需求：将1.txt 2.txt 3.txt文件中的数据合并到一个文件中。
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        List<FileInputStream> list = new ArrayList<>();
        SequenceInputStream sis = null;
        FileOutputStream fos = null;
        try {
            list.add(new FileInputStream("src/aaa/IOtest.txt"));
            list.add(new FileInputStream("src/aaa/pw.txt"));
            list.add(new FileInputStream("src/aaa/a.txt"));
            Enumeration<FileInputStream> enumeration = Collections.enumeration(list);
            sis = new SequenceInputStream(enumeration);
            fos = new FileOutputStream("src/aaa/sis.txt");
            byte[] bys = new byte[1024];
            int len ;
            while ((len = sis.read(bys)) != -1){
                fos.write(bys);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(sis != null){
                try {
                    sis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
