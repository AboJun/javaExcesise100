package Noted.zhang8_IOStream.PrintStream打印流;

import java.io.*;

/*
 * PrintWriter：字符打印流。
 * 构造函数参数：
 * 1，字符串路径。
 * 2， File对象。
 * 3，字节输出流。
 * 4，字符输出流。
 *
 */
public class PrintStreamDemo {
    public static void main(String[] args) {

        try (  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter("src/aaa/pw.txt")){
            String line;
            while ((line = br.readLine()) != null){
                if(line.equals("end"))break;
                pw.println(line);
                pw.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
