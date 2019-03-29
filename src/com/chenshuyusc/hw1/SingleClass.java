package com.chenshuyusc.hw1;

public class SingleClass {

    // Hide the constructor of the class
    private SingleClass() {
    }

    // instance of the class
    private static SingleClass singleInstance = new SingleClass();

    // public static operation that return the sole instance of the class
    synchronized public static SingleClass getInstance(){
        return singleInstance;
    }
}
