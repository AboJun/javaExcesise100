package Noted.zhang8_IOStream.深度遍历_递归.删除带内容的文件夹_递归;

import java.io.File;

public class RemoveDemo {
    public static void main(String[] args) {
        File file = new File("src/bbbb");
        removeDir(file);
    }
    public static void removeDir(File dir){
        File[] files = dir.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                removeDir(file);
            }else {
                System.out.println(file.getName()+":"+file.delete());
            }
        }
        System.out.println(dir.getName()+":"+dir.delete());

    }
}
