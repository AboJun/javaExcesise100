package Noted.zhang8_IOStream.切割与合并_序列化流.合并文件;

import java.io.File;
import java.io.FilenameFilter;

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


