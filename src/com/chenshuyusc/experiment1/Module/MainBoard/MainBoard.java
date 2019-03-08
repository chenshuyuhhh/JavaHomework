package com.chenshuyusc.experiment1.Module.MainBoard;

import com.chenshuyusc.experiment1.Module.Module;

public class MainBoard extends Module {
    private double speed = 250;

    public MainBoard() {
        setBrand("Asus"); // 设置默认品牌
    }

    public MainBoard(String name, double speed, int price) {
        super(name, price);
        this.speed = speed;
        setBrand("Asus"); // 设置默认品牌
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void describe() {
        System.out.println("Module: MainBoard  Brand: " + String.format("%-13s", getBrand()) + "Name: " + String.format("%-14s", getName()) + String.format("%-15s", "speed: " + getSpeed()) + "price: " + getPrice());
    }
}
