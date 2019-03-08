package com.chenshuyusc.experiment1;

import com.chenshuyusc.experiment1.Module.CPU.CPU;
import com.chenshuyusc.experiment1.Module.HardDisk.HardDisk;
import com.chenshuyusc.experiment1.Module.MainBoard.MainBoard;
import com.chenshuyusc.experiment1.Module.Memory.Memory;
import com.chenshuyusc.experiment1.ModuleFactory.Factory;
import com.chenshuyusc.experiment1.ModuleFactory.ModuleFactory;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("生成你的专属电脑，仅限三次机会！\n第一台电脑：");
        ComputerStore computerStore = new ComputerStore();
        Factory factory = new ModuleFactory();
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入你电脑名字：");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            CPU cpu = (CPU) factory.create("CPU");
            Memory memory = (Memory) factory.create("Memory");
            HardDisk hardDisk = (HardDisk) factory.create("HardDisk");
            MainBoard mainBoard = (MainBoard) factory.create("MainBoard");
            Computer computer = new Computer(name, cpu, memory, hardDisk, mainBoard);
            computerStore.addComputer(computer);
            System.out.println();
        }
        for (Computer computer : computerStore.getComputers()) {
            System.out.println("你创建的电脑们的信息：");
            computer.describe();
            System.out.println("\n电脑开始工作：");
            computer.work();
            System.out.println("\n");
        }
    }
}
