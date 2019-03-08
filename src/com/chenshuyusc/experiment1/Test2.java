package com.chenshuyusc.experiment1;

import com.chenshuyusc.experiment1.Module.CPU.AMDCPU;
import com.chenshuyusc.experiment1.Module.CPU.CPU;
import com.chenshuyusc.experiment1.Module.HardDisk.HardDisk;
import com.chenshuyusc.experiment1.Module.HardDisk.WestDigitalsHardDisk;
import com.chenshuyusc.experiment1.Module.MainBoard.GigabyteMainBoard;
import com.chenshuyusc.experiment1.Module.MainBoard.MainBoard;
import com.chenshuyusc.experiment1.Module.Memory.KingstonMemory;
import com.chenshuyusc.experiment1.Module.Memory.Memory;
import com.chenshuyusc.experiment1.Module.Memory.SamsungMemory;

public class Test2 {
    public static void main(String[] args) {
        ComputerStore computerStore = new ComputerStore();
        CPU cpu1 = new CPU();
        Memory memory1 = new Memory();
        HardDisk hardDisk1 = new HardDisk();
        MainBoard mainBoard1 = new MainBoard();
        Computer computer1 = new Computer("电脑小猪", cpu1, memory1, hardDisk1, mainBoard1);
        computerStore.addComputer(computer1);
        CPU cpu2 = new AMDCPU("cpuZHU", 4, 666);
        Memory memory2 = new SamsungMemory("memoryZHU", 16, 888);
        HardDisk hardDisk2 = new WestDigitalsHardDisk("hardDiskZHU", 256, 999);
        MainBoard mainBoard2 = new GigabyteMainBoard("MainBoardZHU", 222.2, 222);
        Computer computer2 = new Computer("电脑中猪", cpu2, memory2, hardDisk2, mainBoard2);
        computerStore.addComputer(computer2);
        Computer computer3 = new Computer("电脑大猪", cpu1, memory2, hardDisk1, mainBoard2);
        computerStore.addComputer(computer3);

        System.out.println("我创建的电脑们的信息：");
        for (Computer cp : computerStore.getComputers()) {
            cp.describe();
            System.out.println("\n电脑开始工作：");
            cp.work();
            System.out.println("\n");
        }
    }
}
