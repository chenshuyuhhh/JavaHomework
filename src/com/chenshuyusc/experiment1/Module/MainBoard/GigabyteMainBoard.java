package com.chenshuyusc.experiment1.Module.MainBoard;

public class GigabyteMainBoard extends MainBoard {
    public GigabyteMainBoard() {
        setBrand("Gigabyte");
    }

    public GigabyteMainBoard(String name, double speed, int price) {
        super(name, speed, price);
        setBrand("Gigabyte");
    }
}
