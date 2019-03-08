package com.chenshuyusc.experiment1.ModuleFactory;

import com.chenshuyusc.experiment1.Module.MainBoard.AsusMainBoard;
import com.chenshuyusc.experiment1.Module.CPU.IntelCPU;
import com.chenshuyusc.experiment1.Module.Memory.KingstonMemory;
import com.chenshuyusc.experiment1.Module.HardDisk.SeagateHardDisk;
import com.chenshuyusc.experiment1.Module.CPU.CPU;
import com.chenshuyusc.experiment1.Module.HardDisk.HardDisk;
import com.chenshuyusc.experiment1.Module.MainBoard.MainBoard;
import com.chenshuyusc.experiment1.Module.Memory.Memory;

import java.util.Scanner;

/**
 * 和用户交互的组件生产工厂
 * 可以自己输入组件的参数
 */
public class ModuleFactory extends Factory {

    @Override
    public CPU createCPU() {
        Scanner cin = new Scanner(System.in);
        CPU cpu = null;
        System.out.println("请输入你选择的 cpu 品牌（Intel/AMD）：");
        // 组件所属品牌
        String brand = cin.next();
        String className = "com.chenshuyusc.experiment1.Module.CPU." + brand + "CPU";
        Class<?> cls;
        try {
            // 根据获得的品牌名字通过反射获得类的构造方法，以此来生成实例化对象
            cls = Class.forName(className);
            System.out.println("请依次输入 cpu 的 Name（String），coreNum（int），price（int） (用空格分开信息) :");
            String name = cin.next();
            int coreNum = cin.nextInt();
            int price = cin.nextInt();
            cpu = (CPU) cls.getConstructor(String.class, int.class, int.class).newInstance(name, coreNum, price);
        } catch (Throwable throwable) {
            System.out.println("你输入的参数不在范围内（ 若不合法则使用默认的 Intel CPU）");
            cpu = new IntelCPU();
        }
        return cpu;
    }

    @Override
    public Memory createMemory() {
        Scanner cin = new Scanner(System.in);
        Memory memory = null;
        System.out.println("请输入你选择的 memory 品牌（Samsung/Kingston）：");
        // 组件所属品牌
        String brand = cin.next();
        String className = "com.chenshuyusc.experiment1.Module.Memory." + brand + "Memory";
        Class<?> cls;
        try {
            cls = Class.forName(className);
            System.out.println("请依次输入 memory 的 Name（string），volume（int），price（int） (用空格分开信息) :");
            // 每个组件的名字
            String name = cin.next();
            int volume = cin.nextInt();
            // 每个组件的价格
            int price = cin.nextInt();
            memory = (Memory) cls.getConstructor(String.class, int.class, int.class).newInstance(name, volume, price);
        } catch (Throwable e) {
            System.out.println("你输入的 memory 品牌名字不在范围内（ 若不合法则使用默认的 Kingston Memory）");
            memory = new KingstonMemory();
        }
        return memory;
    }

    @Override
    public HardDisk createHardDisk() {
        Scanner cin = new Scanner(System.in);
        HardDisk hardDisk = null;
        System.out.println("请输入你选择的 HardDisk 品牌（Seagate/WestDigitals）：");
        // 组件所属品牌
        String brand = cin.next();
        String className = "com.chenshuyusc.experiment1.Module.HardDisk." + brand + "HardDisk";
        Class<?> cls;
        try {
            cls = Class.forName(className);
            System.out.println("请依次输入 HardDisk 的 Name（string），volume（int），price（int） (用空格分开信息) :");
            // 每个组件的名字
            String name = cin.next();
            int volume = cin.nextInt();
            // 每个组件的价格
            int price = cin.nextInt();
            hardDisk = (HardDisk) cls.getConstructor(String.class, int.class, int.class).newInstance(name, volume, price);
        } catch (Throwable e) {
            System.out.println("你输入的 HardDisk 品牌名字不在范围内（ 若不合法则使用默认的 Seagate HardDisk）");
            hardDisk = new SeagateHardDisk();
        }
        return hardDisk;
    }

    @Override
    public MainBoard createMainBoard() {
        Scanner cin = new Scanner(System.in);
        MainBoard mainBoard = null;
        System.out.println("请输入你选择的 mainBord 品牌（Asus/Gigabyte）：");
        // 组件所属品牌
        String brand = cin.next();
        String className = "com.chenshuyusc.experiment1.Module.MainBoard." + brand + "MainBoard";
        Class<?> cls;
        try {
            cls = Class.forName(className);
            System.out.println("请依次输入 MainBoard  的 Name（string），speed（double），price（int） (用空格分开信息) :");
            // 每个组件的名字
            String name = cin.next();
            double speed = cin.nextDouble();
            // 每个组件的价格
            int price = cin.nextInt();
            mainBoard = (MainBoard) cls.getConstructor(String.class, double.class, int.class).newInstance(name, speed, price);
        } catch (Throwable e) {
            System.out.println("你输入的 MainBorad 品牌名字不在范围内（ 若不合法则使用默认的 Seagate MainBoard）");
            mainBoard = new AsusMainBoard();
        }
        return mainBoard;
    }
}
