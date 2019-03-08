package com.chenshuyusc.experiment1.Module.Memory;

public class KingstonMemory extends Memory {

    public KingstonMemory() {
        setBrand("Kingston");
    }

    public KingstonMemory(String name, int volume, int price) {
        super(name, volume, price);
        setBrand("Kingston");
    }
}
