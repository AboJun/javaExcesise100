package Noted.zhang8_IOStream.三种常见文件过滤器;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * 1-后缀名过滤器
 */
class FilterJavaFile implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".java");
    }
}

/**
 * 2-根据后缀名可以指定任意后缀名过滤的过滤器
 */
class SuffixFilter implements FilenameFilter{
    private String suffix;

    public SuffixFilter(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}
/**
 * 3-隐藏属性过滤器
 * */
class FilterByHidden implements FileFilter{

    @Override
    public boolean accept(File pathname) {
        return !pathname.isHidden();
    }
}


