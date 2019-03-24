package com.chenshuyusc.hw3;

import java.io.IOException;
import java.util.List;

/**
 * 几种读取文件的方法
 * 以字节、字符、行、全部等方式读取
 */
public interface IReading {

    byte[] readByByte() throws IOException; // 按字节读取

    char[] readByChar() throws IOException; // 按字符读取

    List<String> readByAllLines() throws IOException;  // 按行读取

    String readAll() throws IOException; // 按字符串读取
}
