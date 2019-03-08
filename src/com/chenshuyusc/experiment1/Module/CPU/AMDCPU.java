package com.chenshuyusc.experiment1.Module.CPU;

public class AMDCPU extends CPU {
    public AMDCPU() {
        setBrand("AMD");
    }

    public AMDCPU(String name, int coreNum, int price) {
        super(name, coreNum, price);
        setBrand("AMD");
    }
}
