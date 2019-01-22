package Noted.zhang8_IOStream.转换流;

import java.io.*;

/**
 * InputStreamReader  将字节流转换成字符流
 * OutputStreamWriter
 *
 * * FileWriter：其实就是转换流指定了本机默认码表的体现。而且这个转换流的子类对象，可以方便操作文本文件。
 * 简单说：操作文件的字节流+本机默认的编码表。这是按照默认码表来操作文件的便捷类。
 *
 * 如果操作文本文件需要明确具体的编码。 FileWriter就不行了。必须用转换流
 */
public class TransStreamDemo1 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in,"utf-8");
        BufferedReader br = new BufferedReader(isr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream("src/aaa/isrTest.txt"),"GBK"));
        System.out.println("输入:");
        String line;
        while ((line = br.readLine()) != null) {
            if(line.equals("end")){
                break;
            }
            System.out.println("字符:" + line.toUpperCase());
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
        isr.close();
        in.close();

    }
}
