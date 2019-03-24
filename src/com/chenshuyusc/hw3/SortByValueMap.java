package com.chenshuyusc.hw3;

import java.util.*;

/**
 * Class SortByValueMap is a map which can be used to sort by value.
 * There is a TreeMap in the class.
 * 类似于装饰模式
 */
public class SortByValueMap {
    private Map map;
    private List<Map.Entry<String, Integer>> list; // 便于将 map 转换成 list 进行排序

    // 实现 Comparator 这个接口的 compare 方法便于排序
    private Comparator<Map.Entry<String, Integer>> UpSortByValue = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    };

    private Comparator<Map.Entry<String, Integer>> DownSortByValue = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    };

    public SortByValueMap() {
    }

    public SortByValueMap(Map map) {
        this.map = map;
        list = new ArrayList(map.entrySet());
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
        list = new ArrayList(map.entrySet());
    }

    // sort from down to top
    public void upSort() {
        Collections.sort(list, UpSortByValue);
    }

    // sort from top to down
    public void downSort() {
        Collections.sort(list, DownSortByValue);
    }

    // used to display message in map
    public String toString() {
        StringBuffer s = new StringBuffer("");
        for (Map.Entry<String, Integer> entry : list) {
            s.append(entry.getKey() + " " + entry.getValue() + "\n");
        }
        return s.toString();
    }
}
