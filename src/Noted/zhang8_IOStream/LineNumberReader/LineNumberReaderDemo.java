package Noted.zhang8_IOStream.LineNumberReader;
/*
缓冲字符输入流，跟踪行号。
该类定义用于分别设置和获得当前行号的方法setLineNumber(int)和getLineNumber() 。
构造方法:   LineNumberReader​(Reader in) 使用默认的输入缓冲区大小创建一个新的行号阅读器。
            LineNumberReader​(Reader in, int sz) 创建一个新的行号阅读器，将字符读入给定大小的缓冲区。
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\JavaEE\\javaExcesise\\src/aaa/IOtest.txt");
        LineNumberReader lnr = new LineNumberReader(fr);
        String line = null;
        lnr.setLineNumber(100);
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);

        }
        lnr.close();
    }
}
