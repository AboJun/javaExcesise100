package Noted.zhang8_IOStream.切割与合并_序列化流.文件切割器;

import java.io.*;
import java.util.Properties;

public class SplitFileDemo {
    private static int buffSize = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        File file = new File("src/aaa/0.mp3");
        splitFile(file);
    }
    public static void splitFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = null;
        byte[] bys = new byte[buffSize];
        int len ;
        int count = 1;
        /*
         * 切割文件时，必须记录住被切割文件的名称，以及切割出来碎片文件的个数。 以方便于合并。
         * 这个信息为了进行描述，使用键值对的方式。用到了properties对象
         *
         */
        Properties pop = new Properties();

        File dir = new File("src/aaa/properties");
        if(!dir.exists()){
            dir.mkdirs();
        }
        while ((len = fis.read(bys)) != -1){
            fos = new FileOutputStream(new File(dir,(count++)+".part"));
            fos.write(bys);
            fos.close();
        }
        pop.setProperty("partCount", count+"");
        pop.setProperty("fileName", file.getName());
        fos = new FileOutputStream(new File(dir,count+".properties"));
        pop.store(fos, "save file info");
    }
}
