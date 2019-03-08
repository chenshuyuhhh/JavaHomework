package com.chenshuyusc.experiment1.Module.HardDisk;

public class WestDigitalsHardDisk extends HardDisk {

    public WestDigitalsHardDisk() {
        setBrand("WestDigitals");
    }

    public WestDigitalsHardDisk(String name, int volume, int price) {
        super(name, volume, price);
        setBrand("WestDigitals");
    }
}