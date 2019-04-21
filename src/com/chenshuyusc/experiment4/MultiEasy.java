package com.chenshuyusc.experiment4;

public class MultiEasy {
    private double[][] m1;
    private double[][] m2;
    private double[] l1;
    private double[] l2;
    private int row;
    private int column;
    private double result;
    private MultiMatrix mm;

    public MultiEasy(MultiMatrix mm) {
        this.mm = mm;
    }

    public MultiEasy(MultiMatrix mm, double[][] m1, double[][] m2) {
        this.mm = mm;
        this.m1 = m1;
        this.m2 = m2;
    }

    public double[] getL1() {
        return l1;
    }

    public double[] getL2() {
        return l2;
    }

    public void setL1(double[] l1) {
        this.l1 = l1;
    }

    public void setL2(double[] l2) {
        this.l2 = l2;
    }

    public void setmsg(int l1, int l2) {
        row = l1;
        column = l2;
    }

    public void setmsg(double[] l1, double[] l2, int row, int column) {
        this.l1 = l1;
        this.l2 = l2;
        this.row = row;
        this.column = column;
    }

    public void setmsg(double[][] m1, double[][] m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    public void setM1(double[][] m1) {
        this.m1 = m1;
    }

    public void setM2(double[][] m2) {
        this.m2 = m2;
    }

    public double[][] getM1() {
        return m1;
    }

    public double[][] getM2() {
        return m2;
    }

    public MultiMatrix getMm() {
        return mm;
    }

    public void setMm(MultiMatrix mm) {
        this.mm = mm;
    }

    /**
     * 利用内部已有参数
     */
    public void cumpute() throws InterruptedException {
        cumpute(l1, l2, row, column);
    }

    /**
     * 所有参数均从外部传来
     *
     * @param l1
     * @param l2
     * @param row
     * @param column
     */

    public void cumpute(double[] l1, double[] l2, int row, int column) throws InterruptedException {
        double result = 0;
        for (int i = 0; i < l1.length; i++) {
            result = l1[i] * l2[i];
        }
        // System.out.println("row: " + row + "  column: " + column + "  result: " + result);
        mm.change(row, column, result);
    }

    /**
     * 取出数组中的一列，并存入一维数组中
     *
     * @param m      二维数组
     * @param column 第几列
     * @return
     */
    public double[] getColumn(double[][] m, int column) {
        double[] l2 = new double[m.length];
        for (int k = 0; k < m.length; k++) {
            l2[k] = m[k][column];
        }
        return l2;
    }

    public double[] getColumn(int column) {
        return getColumn(m2, column);
    }
}
