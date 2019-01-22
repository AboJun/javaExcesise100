package Noted.zhang8_IOStream.键盘录入;

import java.io.IOException;
import java.io.InputStream;

/*
 * 读取一个键盘录入的数据，并打印在控制台上。
 *
 * 键盘本身就是一个标准的输入设备。
 * 对于java而言，对于这种输入设备都有对应的对象。
 */
public class ReadKey {
    public static void main(String[] args) throws IOException {
        readKey();
    }

    /*
     * 获取用户键盘录入的数据，
     * 并将数据变成大写显示在控制台上，
     * 如果用户输入的是over，结束键盘录入。
     *
     * 思路：
     * 1，因为键盘录入只读取一个字节，要判断是否是over，需要将读取到的字节拼成字符串。
     * 2，那就需要一个容器。 StringBuilder.
     * 3，在用户回车之前将录入的数据变成字符串判断即可。
     */
    public static void readKey() throws IOException {
        System.out.println("请输入英文...(输入over退出)");
        //键盘读取流
        InputStream is = System.in;
        //创建容器
        StringBuilder sb = new StringBuilder();

        int ch = 0;
         while ((ch = is.read()) != -1){
             if(ch == '\r') continue;
             if(ch == '\n'){
                 String temp = sb.toString();
                 if("over".equals(temp))break;
                 System.out.println(temp.toUpperCase());
                 sb.delete(0, sb.length());
             }else {
                 sb.append((char)ch);
             }
         }
    }
}
