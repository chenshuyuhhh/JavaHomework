package com.chenshuyusc.hw3;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 可读或者写操作的类
 * 根据其子类的继承的接口决定其是读还是写
 * 内部有文件和文件格式作为成员变量
 */
public class FileReadorWrite {
    private File file = null;
    private String format = null;

    public FileReadorWrite() {
    }

    public FileReadorWrite(File file) throws FileNotFoundException {
        this.file = file;
    }

    public FileReadorWrite(File file, String format) throws FileNotFoundException {
        this.file = file;
        this.format = format;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) throws FileNotFoundException {
        this.file = file;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
