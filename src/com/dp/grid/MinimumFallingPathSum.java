package com.dp.grid;

import com.utils.MatrixUtil;
import com.utils.Utils;

/**
 * * https://leetcode.com/problems/minimum-falling-path-sum/
 * * 931. Minimum Falling Path Sum
 */
public class MinimumFallingPathSum {

    /**
     * * Recursion: 3^(m*n)
     * * Space : O(avg length of path)
     *
     * @param matrix
     * @return
     */
    public int minimumFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, minimumFallingPathSum(matrix, m, n, 0, i));
        }
        return min;
    }

    private int minimumFallingPathSum(int[][] matrix, int m, int n, int row, int col) {
        // for col = -1 and col == n
        if (col < 0 || col >= n)
            return 10000000;
        if (row == m - 1)
            return matrix[row][col];
        // Down
        int down = matrix[row][col] + minimumFallingPathSum(matrix, m, n, row + 1, col);

        // diagonally left
        int leftDiagonal = matrix[row][col] + minimumFallingPathSum(matrix, m, n, row + 1, col - 1);

        // diagonally right
        int rightDiagonal = matrix[row][col] + minimumFallingPathSum(matrix, m, n, row + 1, col + 1);

        return Math.min(down, Math.min(leftDiagonal, rightDiagonal));
    }


    /**
     * * Memorization: O(m * n)
     * * Space : O(m*n)
     *
     * @param matrix
     * @return
     */
    public int minimumFallingPathSumMemorization(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, minimumFallingPathSumMemorization(matrix, dp, m, n, 0, i));
        }
        return min;
    }

    private int minimumFallingPathSumMemorization(int[][] matrix, int[][] dp, int m, int n, int row, int col) {
        // for col = -1 and col == n
        if (col < 0 || col >= n)
            // never use 10^7 use actual number
            return 10000000;
        if (row == m - 1)
            return matrix[row][col];
        if (dp[row][col] != 0)
            return dp[row][col];

        // Down
        int down = matrix[row][col] + minimumFallingPathSumMemorization(matrix, dp, m, n, row + 1, col);

        // diagonally left
        int leftDiagonal = matrix[row][col] + minimumFallingPathSumMemorization(matrix, dp, m, n, row + 1, col - 1);

        // diagonally right
        int rightDiagonal = matrix[row][col] + minimumFallingPathSumMemorization(matrix, dp, m, n, row + 1, col + 1);

        return dp[row][col] = Math.min(down, Math.min(leftDiagonal, rightDiagonal));
    }

    public int minimumFallingPathSumDP(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if(m == 1 && n == 1)
            return matrix[0][0];
        
        int minValue = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int LeftDiagonal = j - 1 < 0 ? Integer.MAX_VALUE : matrix[i - 1][j - 1];
                int top = matrix[i - 1][j];
                int rightDiagonal = (j + 1 >= n) ? Integer.MAX_VALUE : matrix[i - 1][j + 1];
                matrix[i][j] = matrix[i][j] + Math.min(LeftDiagonal, Math.min(top, rightDiagonal));
                if (i == m - 1)
                    minValue = Math.min(minValue, matrix[i][j]);
            }
        }
        return minValue;
    }


    public static void main(String[] args) {
        MinimumFallingPathSum obj = new MinimumFallingPathSum();

        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int[][] matrix1 = {{-19, 57}, {-40, -5}};
        int[][] matrix2 = {{4, 5, 6}, {0, 7, -1}, {8, 7, 10}};
        int[][] matrix3 = {{100, -42, -46, -41}, {31, 97, 10, -10}, {-58, -51, 82, 89}, {51, 81, 69, -51}};
        int[][] matrix4 = {{100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}};

        Utils.printHeadLine("Recursion");

        System.out.println(obj.minimumFallingPathSum(matrix));
        System.out.println(obj.minimumFallingPathSum(matrix1));
        System.out.println(obj.minimumFallingPathSum(matrix2));
        System.out.println(obj.minimumFallingPathSum(matrix3));
        System.out.println(obj.minimumFallingPathSum(matrix4));

        Utils.printHeadLine("Memorization");

        System.out.println(obj.minimumFallingPathSumMemorization(matrix));
        System.out.println(obj.minimumFallingPathSumMemorization(matrix1));
        System.out.println(obj.minimumFallingPathSumMemorization(matrix2));
        System.out.println(obj.minimumFallingPathSumMemorization(matrix3));
        System.out.println(obj.minimumFallingPathSumMemorization(matrix4));

        Utils.printHeadLine("Dynamic Programming");

        System.out.println(obj.minimumFallingPathSumDP(matrix));
        System.out.println(obj.minimumFallingPathSumDP(matrix1));
        System.out.println(obj.minimumFallingPathSumDP(matrix2));
        System.out.println(obj.minimumFallingPathSumDP(matrix3));
        System.out.println(obj.minimumFallingPathSumDP(matrix4));

    }
}
