package com.dp.grid;

import com.utils.MatrixUtil;
import com.utils.Utils;

/**
 * * https://leetcode.com/problems/minimum-path-sum/
 * * 64. Minimum Path Sum
 */
public class MinimumPathSum {

    /**
     * * Recursion
     * Time : 2 ^(m*n)
     * * Space : O(m+n) -> Path
     *
     * @param matrix
     * @return
     */
    public int minPathSumRecursion(int[][] matrix) {
        return minPathSumRecursion(matrix, 0, 0);
    }

    int minPathSumRecursion(int[][] matrix, int row, int col) {

        if (row == matrix.length - 1 && col == matrix[0].length - 1)
            return matrix[row][col];
        if (row >= matrix.length || col >= matrix[0].length)
            return 1000;

        // Moving right
        int rightPathSum = matrix[row][col] + minPathSumRecursion(matrix, row, col + 1);

        // Moving down
        int downPathSum = matrix[row][col] + minPathSumRecursion(matrix, row + 1, col);

        return Math.min(rightPathSum, downPathSum);
    }

    /**
     * * Recursion with Memorization
     * * Time: O(m*n)
     * * Space: O(m*n) -> DP Matrix + O(m+n) -> Stack Space
     *
     * @param matrix
     * @return
     */
    public int minPathSumMemorization(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        return minPathSumMemorization(matrix, dp, 0, 0);
    }

    int minPathSumMemorization(int[][] matrix, int[][] dp, int row, int col) {

        if (row == matrix.length - 1 && col == matrix[0].length - 1)
            return matrix[row][col];
        if (row >= matrix.length || col >= matrix[0].length)
            return 1000;
        if (dp[row][col] != 0)
            return dp[row][col];

        // Moving right
        int rightPathSum = matrix[row][col] + minPathSumMemorization(matrix, dp, row, col + 1);

        // Moving down
        int downPathSum = matrix[row][col] + minPathSumMemorization(matrix, dp, row + 1, col);

        return dp[row][col] = Math.min(rightPathSum, downPathSum);
    }

    /**
     * * Dynamic Programming
     * Time: O(m*n)
     * * Space : O(1)
     * @param matrix
     * @return
     */
    public int minPathSumDP(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int len = m > n ? m : n;
        for (int i = 1; i < len; i++) {
            if (i < m)
                matrix[i][0] += matrix[i - 1][0];
            if (i < n)
                matrix[0][i] += matrix[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += Math.min(matrix[i][j - 1], matrix[i - 1][j]);
            }
        }
        return matrix[m - 1][n - 1];
    }


    public static void main(String[] args) {
        MinimumPathSum obj = new MinimumPathSum();
        int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        Utils.printHeadLine("Recursion");
        System.out.println(obj.minPathSumRecursion(matrix));
        System.out.println(obj.minPathSumRecursion(matrix1));
        System.out.println(obj.minPathSumRecursion(matrix2));

        Utils.printHeadLine("Recursion Memorization");
        System.out.println(obj.minPathSumMemorization(matrix));
        System.out.println(obj.minPathSumMemorization(matrix1));
        System.out.println(obj.minPathSumMemorization(matrix2));

        Utils.printHeadLine("Dynamic Programming");
        System.out.println(obj.minPathSumDP(matrix));
        System.out.println(obj.minPathSumDP(matrix1));
        System.out.println(obj.minPathSumDP(matrix2));

    }

}
