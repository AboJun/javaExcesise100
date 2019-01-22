package Noted.zhang8_IOStream.深度遍历_递归;

import java.io.File;

/**
 * 递归遍历查找文件
 */
public class TraversalDemo {
    public static void main(String[] args) {
        File file = new File("src");
        listAll(file, 0);
    }

    public static void listAll(File file, int level) {
        System.out.println(getSpace(level)+file.getName());
        level++;
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()){
                listAll(file1,level );
            }else {
                System.out.println(getSpace(level)+file1.getName());
            }
        }
    }

    public static String getSpace(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("|--");
        for(int x = 0; x < level; x++){
            sb.insert(0,"|  ");
        }
        return sb.toString();
    }
}
