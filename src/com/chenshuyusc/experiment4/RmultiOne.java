package com.chenshuyusc.experiment4;

/**
 * 为某一行和某一列的相乘开一个线程
 */
public class RmultiOne extends MultiEasy implements Runnable {

    public RmultiOne(MultiMatrix mm) {
        super(mm);
    }

    @Override
    public void run() {
        try {
            cumpute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
