package com.dp.grid;

public class MinPathSumInGrid {

    /**
     * * Movement left and down
     *
     * @param matrix
     * @return
     */
    public int minPathSumRecursion(int[][] matrix) {
        return minPathSumRecursion(matrix, 0, 0);
    }

    public int minPathSumRecursion(int[][] matrix, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length)
            return 0;

        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            return 0;
        }

        int rightPathSum = matrix[row][col] + minPathSumRecursion(matrix, row, col + 1);
        int leftPathSum =  matrix[row][col] + minPathSumRecursion(matrix, row + 1, col);

        return Math.max(rightPathSum, leftPathSum);
    }

    public static void main(String[] args) {
        MinPathSumInGrid obj = new MinPathSumInGrid();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(obj.minPathSumRecursion(matrix));
    }

}

// 1 2 3
// 4 5 6
// 7 8 9