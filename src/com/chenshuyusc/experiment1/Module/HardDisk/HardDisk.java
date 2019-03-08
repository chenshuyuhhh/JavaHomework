package com.chenshuyusc.experiment1.Module.HardDisk;

import com.chenshuyusc.experiment1.Module.Module;

public class HardDisk extends Module {
    private int volume = 256;

    public HardDisk() {
        setBrand("Seagate"); // 设置默认品牌
    }

    public HardDisk(String name, int volume, int price) {
        super(name, price);
        this.volume = volume;
        setBrand("Seagate"); // 设置默认品牌
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void describe() {
        System.out.println("Module: HardDisk   Brand: " + String.format("%-13s", getBrand()) + "Name: " + String.format("%-14s", getName()) + String.format("%-15s", "volume: " + getVolume()) + "price: " + getPrice());
    }
}
