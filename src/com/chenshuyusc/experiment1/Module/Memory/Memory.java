package com.chenshuyusc.experiment1.Module.Memory;

import com.chenshuyusc.experiment1.Module.Module;

public class Memory extends Module {
    private int volume = 16;

    public Memory() {
        setBrand("Kingston"); // 设置默认品牌
    }

    public Memory(String name, int volume, int price) {
        super(name, price);
        this.volume = volume;
        setBrand("Kingston"); // 设置默认品牌
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void describe() {
        System.out.println("Module: Memory     Brand: " + String.format("%-13s", getBrand()) + "Name: " + String.format("%-14s", getName()) + String.format("%-15s", "volume: " + getVolume()) + "price: " + getPrice());
    }
}
