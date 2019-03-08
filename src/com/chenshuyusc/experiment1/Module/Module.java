package com.chenshuyusc.experiment1.Module;

/**
 * 所有组件的抽象父类，含有组件共有的基本信息：brand、name、price
 */
public abstract class Module implements IModuleWork {

    private String brand;// 存品牌
    private String name = "no name";
    private int price = 888;

    public Module() {
    }

    public Module(String name, int price) {
        this.name = name;
        this.price = price;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void work() {
        System.out.println(getName() + " work");
    }

    // 待实现的每个具体实现类的描述方法
    public abstract void describe();
}
