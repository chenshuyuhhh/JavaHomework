package com.chenshuyusc.experiment4;

import java.util.Random;

/**
 * 矩阵随机生成类
 */
public class MatrixGenerator {
    private int row; // 行
    private int column; // 列
    private Random random = new Random(); // 用于生成随机数

    public MatrixGenerator() {

    }

    public MatrixGenerator(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    /**
     * 可以根据行数、列数获得随机矩阵，并把矩阵存在 double 二维数组中
     *
     * @param row
     * @param column
     * @return
     */
    public double[][] getMatrix(int row, int column) {
        double[][] matrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextDouble() * 10;
            }
        }
        return matrix;
    }

    /**
     * 在没有参数的时候，用默认参数构造矩阵
     *
     * @return
     */
    public double[][] getMatrix() {
        return getMatrix(row, column);
    }
}
