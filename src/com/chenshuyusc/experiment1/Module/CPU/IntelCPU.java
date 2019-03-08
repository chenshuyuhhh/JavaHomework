package com.chenshuyusc.experiment1.Module.CPU;

public class IntelCPU extends CPU {
    public IntelCPU() {
        setBrand("Intel");
    }

    public IntelCPU(String name, int coreNum, int price) {
        super(name, coreNum, price);
        setBrand("Intel");
    }
}
