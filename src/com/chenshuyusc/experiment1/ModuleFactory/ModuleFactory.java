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
        String className = "com.chenshuyusc.experiment1.BrandModule." + brand + "CPU";
        Class<?> cls;
        try {
            cls = Class.forName(className);
            System.out.println("请依次输入 cpu 的 Name，coreNum，price (用空格分开信息) :");
            // 每个组件的名字
            String name = cin.next();
            int coreNum = cin.nextInt();
            // 每个组件的价格
            int price = cin.nextInt();
            cpu = (CPU) cls.getConstructor(String.class, int.class, int.class).newInstance(name, coreNum, price);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("你输入的 cpu 品牌名字不在范围内（ 若不合法则使用默认的 Intel CPU）");
            cpu = new IntelCPU();
        } catch (Exception e) {
            e.printStackTrace();
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
        String className = "com.chenshuyusc.experiment1.BrandModule." + brand + "Memory";
        Class<?> cls;
        try {
            cls = Class.forName(className);
            System.out.println("请依次输入 memory 的 Name，volume，price (用空格分开信息) :");
            // 每个组件的名字
            String name = cin.next();
            int volume = cin.nextInt();
            // 每个组件的价格
            int price = cin.nextInt();
            memory = (Memory) cls.getConstructor(String.class, int.class, int.class).newInstance(name, volume, price);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("你输入的 memory 品牌名字不在范围内（ 若不合法则使用默认的 Kingston Memory）");
            memory = new KingstonMemory();
        } catch (Exception e) {
            e.printStackTrace();
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
        String className = "com.chenshuyusc.experiment1.BrandModule." + brand + "HardDisk";
        Class<?> cls;
        try {
            cls = Class.forName(className);
            System.out.println("请依次输入 HardDisk 的 Name，volume，price (用空格分开信息) :");
            // 每个组件的名字
            String name = cin.next();
            int volume = cin.nextInt();
            // 每个组件的价格
            int price = cin.nextInt();
            hardDisk = (HardDisk) cls.getConstructor(String.class, int.class, int.class).newInstance(name, volume, price);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("你输入的 HardDisk 品牌名字不在范围内（ 若不合法则使用默认的 Seagate HardDisk）");
            hardDisk = new SeagateHardDisk();
        } catch (Exception e) {
            e.printStackTrace();
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
        String className = "com.chenshuyusc.experiment1.BrandModule." + brand + "MainBoard";
        Class<?> cls;
        try {
            cls = Class.forName(className);
            System.out.println("请依次输入 MainBoard  的 Name，speed，price (用空格分开信息) :");
            // 每个组件的名字
            String name = cin.next();
            double speed = cin.nextDouble();
            // 每个组件的价格
            int price = cin.nextInt();
            mainBoard = (MainBoard) cls.getConstructor(String.class, double.class, int.class).newInstance(name, speed, price);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("你输入的 MainBorad 品牌名字不在范围内（ 若不合法则使用默认的 Seagate MainBoard）");
            mainBoard = new AsusMainBoard();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainBoard;
    }
}
