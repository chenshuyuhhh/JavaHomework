package com.chenshuyusc.experiment1.Module.Memory;

/**
 * 内存品牌为 Kingston 对应的类，继承自 Memory 父类
 */
public class KingstonMemory extends Memory {

    public KingstonMemory() {
        setBrand("Kingston");
    }

    public KingstonMemory(String name, int volume, int price) {
        super(name, volume, price);
        setBrand("Kingston");
    }
}
