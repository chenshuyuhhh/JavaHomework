package com.chenshuyusc.experiment1.ModuleFactory;

import com.chenshuyusc.experiment1.Module.CPU.CPU;
import com.chenshuyusc.experiment1.Module.HardDisk.HardDisk;
import com.chenshuyusc.experiment1.Module.MainBoard.MainBoard;
import com.chenshuyusc.experiment1.Module.Memory.Memory;
import com.chenshuyusc.experiment1.Module.*;

import java.util.Scanner;

/**
 * 根据输入字符创建对应的组件
 */
public abstract class Factory {
    public final Module create(String kind) {
        switch (kind) {
            case "CPU":
                return createCPU();
            case "Memory":
                return createMemory();
            case "HardDisk":
                return createHardDisk();
            case "MainBoard":
                return createMainBoard();
            default: {
                System.out.println("你输入的组件不在范围内，请重新输入：");
                Scanner scanner = new Scanner(System.in);
                String module = scanner.next();
                return create(module);
            }
        }
    }

    public abstract CPU createCPU();

    public abstract Memory createMemory();

    public abstract HardDisk createHardDisk();

    public abstract MainBoard createMainBoard();
}
