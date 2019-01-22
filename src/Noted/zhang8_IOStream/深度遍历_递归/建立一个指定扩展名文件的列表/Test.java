package Noted.zhang8_IOStream.深度遍历_递归.建立一个指定扩展名文件的列表;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("src");

        getFileList(file);
    }
    public  static void getFileList(File file) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/aaa/list.txt",true));
        File[] files = file.listFiles(pathname -> {
            if(pathname.getName().endsWith(".java")||pathname.isDirectory()){
                return true;
            }else return false;
        });
        for (File file1 : files) {
            if(file1.isDirectory()){
                getFileList(file1);
            }else {
                bw.write(file1.getAbsolutePath());
                bw.newLine();
            }
        }
        bw.close();
    }
}
