package com.chenshuyusc.hw3;

import java.io.IOException;
import java.util.List;

/**
 * I/O 写操作的方法
 * 以字节、字符、行、全部等方式写
 */
public interface IWriting {

    void writeByByte(byte[] bytes) throws IOException; // 按字节写入

    void writeByChar(char[] chars) throws IOException; // 按字符写入

    void writeByAllLines(List<String> strings) throws IOException; // 按行写入

    void writeAll(String str) throws IOException; // 按字符串写入
}
