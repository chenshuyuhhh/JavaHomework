package com.chenshuyusc.experiment1.Module.HardDisk;

public class SeagateHardDisk extends HardDisk {

    public SeagateHardDisk() {
        setBrand("Seagate");
    }

    public SeagateHardDisk(String name, int volume, int price) {
        super(name, volume, price);
        setBrand("Seagate");
    }
}
