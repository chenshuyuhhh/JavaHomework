package com.chenshuyusc.experiment1.Module.CPU;

import com.chenshuyusc.experiment1.Module.Module;

public class CPU extends Module {
    private int coreNum = 4;

    public CPU() {
        setBrand("Intel"); // 设置默认品牌
    }

    public CPU(String name, int coreNum, int price) {
        super(name, price);
        this.coreNum = coreNum;
        setBrand("Intel");
    }

    public int getCoreNum() {
        return coreNum;
    }

    public void setCoreNum(int coreNum) {
        this.coreNum = coreNum;
    }

    @Override
    public void describe() {
        System.out.println("Module: CPU        Brand: " + String.format("%-13s", getBrand()) + "Name: " + String.format("%-14s", getName()) + String.format("%-15s", "coreNum: " + getCoreNum()) + "price: " + getPrice());
    }
}
