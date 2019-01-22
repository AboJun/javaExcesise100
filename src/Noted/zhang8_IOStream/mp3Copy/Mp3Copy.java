package Noted.zhang8_IOStream.mp3Copy;

import java.io.*;

/**
 * 字节流复制文件的4种方法比较
 * BufferedInputStream效率较高
 */
public class Mp3Copy {
    public static void main(String[] args) {
        File file = new File("src/aaa/0.mp3");//源文件,大小8.22MB
        File fileCopy = new File("src/aaa/0_copy.mp3");//复制文件
        copy_1(file, fileCopy);//20毫秒
        //copy_2(file, fileCopy);//20毫秒
        //copy_3(file, fileCopy);//65047毫秒
        //copy_4(file, fileCopy);//22毫秒,不建议使用
    }

    public static void copy_1(File file,File fileCopy){
        long time1 = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileCopy))){
            byte[] bys = new byte[1024 * 8];
            int len ;
            while ((len = bis.read(bys)) != -1){
                bos.write(bys);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1+"毫秒");//20毫秒
    }

    public static void copy_2(File file,File fileCopy){
        long time1 = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileCopy)){
            byte[] bys = new byte[1024 * 8];
            int len;
            while ((len = fis.read(bys)) != -1){
                fos.write(bys);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1+"毫秒");//20毫秒
    }


    public static void copy_3(File file,File fileCopy){
        long time1 = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(fileCopy)){
            //byte[] bys = new byte[1024 * 8];
            int len;
            while ((len = fis.read()) != -1){
                fos.write(len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1+"毫秒");//65047毫秒
    }

    /*不建议 */
    public static void copy_4(File file,File fileCopy){
        long time1 = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(fileCopy)){
            byte[] bys = new byte[fis.available()];
            fis.read(bys);
            fos.write(bys);
        }catch (IOException e){
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1+"毫秒");//22毫秒
    }
}
