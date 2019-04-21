package com.chenshuyusc.experiment4;

import java.awt.*;

/**
 * 含有有种矩阵相乘的方法
 */
public class MultiMatrix {
    private double[][] matrix1;
    private double[][] matrix2;
    private double[][] result;
    private volatile int count = 0;// 统计线程是否执行完，如果 count = time 则执行完毕
    private long time; //统计计算所耗费的时间
    private int testn; // 记录在用哪种方式计算矩阵

    public MultiMatrix() {

    }

    public MultiMatrix(double[][] matrix1) {
        this.matrix1 = matrix1;
    }

    public MultiMatrix(double[][] matrix1, double[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    public synchronized void change(int row, int column, double number) throws InterruptedException {
        --count;
        result[row][column] = number;
        if (count == 0) {
            time = System.currentTimeMillis() - time;
            printResult();
            if (testn == 1) {
                test(2);
            } else if (testn == 2) {
                test(3);
            } else if (testn == 3) {
                test(4);
            } else {
                Thread.sleep(12000);
                System.out.println("\n全部执行完毕啦！");
            }
        }
    }

    public void setTestn(int testn) {
        this.testn = testn;
    }

    public int getTestn() {
        return testn;
    }

    public int getCount() {
        return count;
    }

    public void setMatrix1(double[][] matrix1) {
        this.matrix1 = matrix1;
    }

    public double[][] getMatrix1() {
        return matrix1;
    }

    public void setMatrix2(double[][] matrix2) {
        this.matrix2 = matrix2;
    }

    public double[][] getMatrix2() {
        return matrix2;
    }

    public void multiByEveryLine() {
        multiByEveryLine(matrix1, matrix2);
    }

    public void multiByLine() {
        multiByLine(matrix1, matrix2);
    }

    public void multiByOddorEven() {
        multiByOddorEven(matrix1, matrix2);
    }

    /**
     * 为每行乘每列开一个线程，即总共开m*n个线程
     *
     * @param m1
     * @param m2
     */
    public void multiByEveryLine(double[][] m1, double[][] m2) {
        time = System.currentTimeMillis();
        count = m1.length * m2[0].length;
        result = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                double[] l2 = new double[m2.length];
                for (int k = 0; k < m2.length; k++) {
                    l2[k] = m2[k][j];
                }
                RmultiOne tm = new RmultiOne(this);
                tm.setmsg(m1[i], l2, i, j);
                Thread t = new Thread(tm);
                t.start();
            }
        }
    }

    /**
     * 为每一行开一个线程
     */
    public void multiByLine(double[][] m1, double[][] m2) {
        time = System.currentTimeMillis();
        count = m1.length * m2[0].length;
        result = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            RmuilLine rmuilLine = new RmuilLine(this, m1, m2);
            rmuilLine.setRow(i);
            Thread t = new Thread(rmuilLine);
            t.start();
        }
    }

    public void multiByOddorEven(double[][] m1, double[][] m2) {
        time = System.currentTimeMillis();
        count = m1.length * m2[0].length;
        result = new double[m1.length][m2[0].length];
        RmultiEorO me = new RmultiEorO(this, 0);
        me.setmsg(m1, m2);
        Thread te = new Thread(me);
        RmultiEorO mo = new RmultiEorO(this, 1);
        mo.setmsg(m1, m2);
        Thread to = new Thread(mo);
        te.start();
        to.start();
    }

    public void multiNormal(double[][] m1, double[][] m2) throws InterruptedException {
        time = System.currentTimeMillis();
        count = m1.length * m2[0].length;
        result = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                double[] l2 = new double[m2.length];
                for (int k = 0; k < m2.length; k++) {
                    l2[k] = m2[k][j];
                }
                RMultiNormal rn = new RMultiNormal(this);
                rn.setmsg(m1[i], l2, i, j);
                rn.start();
            }
        }
    }

    public void multiNormal() throws InterruptedException {
        multiNormal(matrix1, matrix2);
    }

    public void printResult() {
        // 打印结果；
        for (double[] aResult : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(aResult[j] + "  ");
            }
            System.out.println();
        }
        System.out.println("总共耗时：" + time + "ms\n\n");
    }

    public void test() throws InterruptedException {
        Thread.sleep(12000);
        switch (testn) {
            case 1: {
                System.out.println("为每一行和每一列相乘开一个线程：");
                multiByEveryLine();
            }
            break;
            case 2: {
                System.out.println("为每一行乘矩阵开一个线程：");
                multiByLine();
            }
            break;
            case 3: {
                System.out.println("为偶数行和奇数行的计算分别开一个线程：");
                multiByOddorEven();
            }
            break;
            case 4: {
                System.out.println("串行，不开线程:");
                multiNormal();
            }
            break;
        }
    }

    public void test(int n) throws InterruptedException {
        setTestn(n);
        test();
    }
}
