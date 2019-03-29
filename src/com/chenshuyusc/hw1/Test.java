package com.chenshuyusc.hw1;

public class Test {
    public static void main(String[] args) {
        SingleClass sc1 = SingleClass.getInstance();
        SingleClass sc2 = SingleClass.getInstance();
        System.out.println("sc1 和 sc2 是否是同一个实例？\n" + (sc1==sc2));
    }
}
