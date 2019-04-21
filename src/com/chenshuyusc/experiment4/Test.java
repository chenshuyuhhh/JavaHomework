package com.chenshuyusc.experiment4;

import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MatrixGenerator mg = new MatrixGenerator();
        Random random = new Random(System.currentTimeMillis());
        int row1 = Math.abs(random.nextInt(50));
        int column1 = Math.abs(random.nextInt(50)); // column1 = row2
        int column2 = Math.abs(random.nextInt(50));
        double[][] m1 = mg.getMatrix(2000, 1600);
        double[][] m2 = mg.getMatrix(1600, 1900);
        Thread.sleep(24000);
        //  double[][] m3 = {{2, 2, 2,2,2}, {1, 1, 1,1,1}, {3, 3, 3,3,3}, {4, 4, 4,4,4},{5,5,5,5,5},{6,6,6,6,6}};//6*5
        // double[][] m4 = {{0, 0, 0, 0,0,0}, {1, 1, 1, 1,1,1}, {2, 2, 2, 2,2,2},{3,3,3,3,3,3},{4,4,4,4,4,4}};//5*6
        MultiMatrix multiMatrix = new MultiMatrix(m1, m2);
        multiMatrix.test(1);
        // multiMatrix.multiByEveryLine(m3, m4);
        // multiMatrix.multiByEveryLine(m1,m2);
        // multiMatrix.setMatrix1(m3);
        //multiMatrix.setMatrix1(m4);
        //multiMatrix.multiByOddorEven(m3,m4);
        //multiMatrix.multiByLine(m3,m4);
    }
}
