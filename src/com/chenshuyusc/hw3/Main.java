package com.chenshuyusc.hw3;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
//        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
//        System.out.println(ToAnalysis.parse(str));

        File fileR = new File("data" + File.separator + "了不起的盖茨比(英文版).txt");
        File fileW = new File("output" + File.separator + "英文版统计结果.txt");
        if (fileR.exists()) {
            try {
                // 使用封装好的 FileRead
                FileRead fileRead = new FileRead(fileR);
                // 调用 FileRead 内部的 readByByte 方法，以字节读文件
                String[] words = processData(fileRead.readByByte());

                // 用 map 存放英文单词和其出现频次之间映射关系
                SortByValueMap sortByValueMap = new SortByValueMap(statistic(words));
                sortByValueMap.downSort();

                FileWrite fileWrite = new FileWrite(fileW);
                fileWrite.writeAll(sortByValueMap.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String[] processData(byte[] bytes) throws UnsupportedEncodingException {
        // 以 unicode 编码方式转换为 String
        String s = new String(bytes, "Unicode");

        // 先把换行符和回车符替换成空格，便于后面用空格来分割字符串
        // 再将标点符号清除掉
        // 最后用 " +" 分割字符串，即一个或者多个空格分割字符串
        // words 存放分割后的英文单词
        String[] words = s.toLowerCase()
                .replaceAll("\\r|\\n", " ")
                .replaceAll("\\p{P}", " ")
                .split("\\s+");
        return words;
    }

    private static Map<String, Integer> statistic(String[] words) {
        // 用 map 存放英文单词和其出现频次之间映射关系
        Map<String, Integer> map = new TreeMap();
        for (String temp : words) {
            if (map.get(temp) == null) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        return map;
    }

}
