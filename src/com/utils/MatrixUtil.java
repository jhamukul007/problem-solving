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
}
