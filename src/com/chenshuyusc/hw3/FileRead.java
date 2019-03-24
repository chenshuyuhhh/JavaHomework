package com.chenshuyusc.hw3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 可用来读的类
 * 不同的读的方式有不同的实现方式
 */
public class FileRead extends FileReadorWrite implements IReading {

    public FileRead() {
        super();
    }

    public FileRead(File file) throws FileNotFoundException {
        super(file);
    }

    public FileRead(File file, String format) throws FileNotFoundException {
        super(file, format);
    }

    @Override
    public void setFile(File file) throws FileNotFoundException {
        super.setFile(file);
    }

    /**
     * 用 FileInputStream 实现的按字节读取
     *
     * @return
     * @throws IOException
     */
    @Override
    public byte[] readByByte() throws IOException {
        InputStream in = null;
        if (getFile() != null) {
            in = new FileInputStream(getFile());
            byte[] bytes = new byte[in.available()];
            int temp;
            int time = 0;
            while ((temp = in.read()) != -1) {
                bytes[time++] = (byte) temp;
            }
            in.close();
            return bytes;
        } else {
            System.out.println("你还没有输入文件");
        }
        return null;
    }

    /**
     * 用 InputStreamReader 实现的按字符读取
     *
     * @return
     * @throws IOException
     */
    @Override
    public char[] readByChar() throws IOException {
        Reader reader = null;
        if (getFile() != null) {
            InputStream in = new FileInputStream(getFile());
            reader = new InputStreamReader(in);
            char[] chars = new char[in.available()];
            int temp;
            int time = 0;
            while ((temp = reader.read()) != -1) {
                chars[time++] = (char) temp;
            }
            reader.close();
            return chars;
        } else {
            System.out.println("你还没有输入文件");
        }
        return null;
    }

    /**
     * 用 BufferReader 实现的按行读取
     *
     * @return
     * @throws IOException
     */
    @Override
    public List<String> readByAllLines() throws IOException {
        BufferedReader reader = null;
        if (getFile() == null) {
            System.out.println("你还没有输入文件");
        } else {
            reader = new BufferedReader(new FileReader(getFile()));
            String temp = null;
            List<String> strings = new ArrayList();
            while ((temp = reader.readLine()) != null) {
                strings.add(temp);
            }
            reader.close();
            return strings;
        }
        return null;
    }

    @Override
    public String readAll() throws IOException {
        List<String> strings = readByAllLines();
        return strings.toString();
    }
}
