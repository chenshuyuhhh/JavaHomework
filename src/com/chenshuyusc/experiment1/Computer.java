package com.chenshuyusc.experiment1;

import com.chenshuyusc.experiment1.Module.CPU.CPU;
import com.chenshuyusc.experiment1.Module.HardDisk.HardDisk;
import com.chenshuyusc.experiment1.Module.MainBoard.MainBoard;
import com.chenshuyusc.experiment1.Module.Memory.Memory;
import com.chenshuyusc.experiment1.Module.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String name;
    private CPU cpu;
    private Memory memory;
    private HardDisk hardDisk;
    private MainBoard mainBoard;
    private List<Module> modules = new ArrayList<>();
    private int price;

    public Computer(String name, CPU cpu, Memory memory, HardDisk hardDisk, MainBoard mainBoard) {
        this.name = name;
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.mainBoard = mainBoard;
        modules.add(cpu);
        modules.add(memory);
        modules.add(hardDisk);
        modules.add(mainBoard);
        computePrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void getCpu() {
        cpu.describe();
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
        modules.set(0, cpu);
    }

    public void getMemory() {
        memory.describe();
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
        modules.set(1, memory);
    }

    public void getHardDisk() {
        hardDisk.describe();
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
        modules.set(2, hardDisk);
    }

    public void getMainBoard() {
        mainBoard.describe();
    }

    public void setMainBoard(MainBoard mainBoard) {
        this.mainBoard = mainBoard;
        modules.set(3, mainBoard);
    }

    private void computePrice() {
        price = cpu.getPrice() + memory.getPrice() + hardDisk.getPrice() + mainBoard.getPrice();
    }

    public void describe() {
        System.out.println("Compter name: " + name);
        for (Module module : modules) {
            module.describe();
        }
        System.out.println("Total Price: " + price);
    }

    public void work() {
        System.out.println("Computer start Working:");
        for (Module module : modules) {
            System.out.print(module.getBrand() + ": ");
            module.work();
        }
        System.out.println("end...");
    }
}
