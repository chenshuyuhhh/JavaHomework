package com.chenshuyusc.experiment4;

/**
 * 为左边的矩阵的每一行开一个线程
 */
public class RmuilLine extends MultiEasy implements Runnable {
    private int row;
    private double[] l1;

    public RmuilLine(MultiMatrix mm) {
        super(mm);
    }

    public RmuilLine(MultiMatrix mm, double[][] m1, double[][] m2) {
        super(mm, m1, m2);
    }

    public RmuilLine(MultiMatrix mm, double[][] m1, double[][] m2, int row) {
        super(mm, m1, m2);
        this.row = row;
    }

    public RmuilLine(MultiMatrix mm, double[] l1, double[][] m2, int row) {
        super(mm);
        this.l1 = l1;
        setM2(m2);
        this.row = row;
    }

    public void setRow(int row) {
        this.row = row;
        l1 = getM1()[row];
    }

    @Override
    public void run() {
        for (int j = 0; j < getM2()[0].length; j++) {
            double[] l2 = getColumn(getM2(), j);
            try {
                cumpute(l1, l2, row, j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
