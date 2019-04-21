package com.chenshuyusc.experiment4;

/**
 * 根据oore的值，开一个线程运算偶数行或者奇数行
 */
public class RmultiEorO extends MultiEasy implements Runnable {
    private int oore; // oore = 1，为奇数行，oore = 0，为偶数行

    public RmultiEorO(MultiMatrix mm) {
        super(mm);
    }

    public RmultiEorO(MultiMatrix mm, int oore) {
        super(mm);
        this.oore = oore;
    }

    @Override
    public void run() {
        for (int i = 0; i < getM1().length; i++) {
            if (i % 2 == oore) {
                for (int j = 0; j < getM2()[0].length; j++) {
                    double[] l2 = getColumn(getM2(), j);
                    try {
                        cumpute(getM1()[i], l2, i, j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
