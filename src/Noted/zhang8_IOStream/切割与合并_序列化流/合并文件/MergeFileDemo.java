package Noted.zhang8_IOStream.切割与合并_序列化流.合并文件;

import java.io.*;
import java.util.*;

public class MergeFileDemo {
    public static void main(String[] args) throws IOException {
        File dir = new File("src/aaa/properties");
        mergeFile(dir);
    }
    public static void mergeFile(File dir) throws IOException {
        /*
         * 获取指定目录下的配置文件对象。
         */
        File[] files = dir.listFiles(new SuffixFilter(".properties"));
        if(files.length != 1){
            System.out.println(dir+"该目录下没有.properties文件或不唯一");
        }
        File conFile = files[0];//记录配置文件对象
        Properties pop = new Properties();
        FileInputStream fis = new FileInputStream(conFile);
        pop.load(fis);
        String fileName = pop.getProperty("fileName");
        int  partCount = Integer.parseInt(pop.getProperty("partCount"));
        //获取该目录下的所有碎片文件。
        File[] files1 = dir.listFiles(new SuffixFilter(".part"));
        if(files1.length != partCount-1){
            throw new RuntimeException("文件个数不对");
        }
        List<FileInputStream> list = new ArrayList<>();
        for (int i = 0; i < partCount-1; i++) {
            list.add(new FileInputStream(files1[i]));
        }
        Enumeration<FileInputStream> enumeration = Collections.enumeration(list);
        SequenceInputStream sis = new SequenceInputStream(enumeration);
        byte[] bys = new byte[1024];
        int len ;
        FileOutputStream fos = new FileOutputStream(new File(dir, "12.mp3"));
        while ((len = sis.read(bys)) != -1){
            fos.write(bys);
            fos.flush();
        }
        fos.close();
        sis.close();


    }
}
