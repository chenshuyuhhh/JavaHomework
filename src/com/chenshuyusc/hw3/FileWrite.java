package com.chenshuyusc.hw3;

import java.io.*;
import java.util.List;

/**
 * 实现文件写操作接口，不同的写的方式，有不同的实现方法
 */
public class FileWrite extends FileReadorWrite implements IWriting {
    public FileWrite() {
    }

    public FileWrite(File file) throws FileNotFoundException {
        super(file);
    }

    public FileWrite(File file, String formate) throws FileNotFoundException {
        super(file, formate);
    }

    /**
     * 用 FileOutputSream 实现的按字节存入
     *
     * @param bytes
     * @throws IOException
     */
    @Override
    public void writeByByte(byte[] bytes) throws IOException {
        OutputStream out = null;
        out = new FileOutputStream(getFile());
        out.write(bytes);
        out.flush();
        out.close();
    }

    /**
     * 用 OutputStreamWriter 实现的按字符写入文件
     *
     * @param data
     * @throws IOException
     */
    @Override
    public void writeByChar(char[] data) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(getFile()));
        for (int i = 0; i < data.length; i++) {
            writer.write(data[i]);
        }
    }

    /**
     * 用 BufferWriter 实现的按行写入
     *
     * @param strings
     * @throws IOException
     */
    @Override
    public void writeByAllLines(List<String> strings) throws IOException {
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(getFile()));
        for (int i = 0; i < strings.size(); i++) {
            writer.write(strings.get(i));
        }

    }

    @Override
    public void writeAll(String str) throws IOException {
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(getFile()));
        writer.write(str);
    }
}
