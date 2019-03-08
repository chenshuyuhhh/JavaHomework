package com.chenshuyusc.experiment1.Module.Memory;

public class SamsungMemory extends Memory {
    public SamsungMemory() {
        setBrand("Samsung");
    }

    public SamsungMemory(String name, int volume, int price) {
        super(name, volume, price);
        setBrand("Samsung");
    }
}
