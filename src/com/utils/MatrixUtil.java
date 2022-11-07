package com.utils;

public class MatrixUtil {

    public static void fill(int[][] matrix, int data) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = data;
            }
        }
    }

    public static void print(boolean[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is null");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
