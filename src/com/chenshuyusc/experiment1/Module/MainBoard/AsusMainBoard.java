package com.chenshuyusc.experiment1.Module.MainBoard;

public class AsusMainBoard extends MainBoard {
    public AsusMainBoard() {
        setBrand("Asus");
    }

    public AsusMainBoard(String name, double speed, int price) {
        super(name, speed, price);
        setBrand("Asus");
    }
}
