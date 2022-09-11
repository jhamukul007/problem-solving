package com.dp.grid;

import com.utils.MatrixUtil;
import com.utils.Utils;

/**
 * * https://leetcode.com/problems/unique-paths-ii/
 * * 63. Unique Paths II
 */
public class UniquePathsII {

    /**
     * *
     * Recursion
     * * Time Complexity: 2^(m*n)
     * * Space : O(length of path) = O(m+n)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        return uniquePathsWithObstaclesRecursion(obstacleGrid, 0, 0);
    }

    private int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid, int row, int col) {
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1)
            return 1;
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length)
            return 0;
        if (obstacleGrid[row][col] == 1)
            return 0;
        return uniquePathsWithObstaclesRecursion(obstacleGrid, row, col + 1) + uniquePathsWithObstaclesRecursion(obstacleGrid, row + 1, col);
    }

    /**
     * *
     * Recursion
     * * Time Complexity: O(m*n)
     * * Space : O(m*n)  -> DP Matrix
     * * O(m+n) -> Recursion stack
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesMemorization(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] dp = new int[m][n];
        MatrixUtil.fill(dp, -1);
        return uniquePathsWithObstaclesMemorization(obstacleGrid, dp, 0, 0);
    }

    private int uniquePathsWithObstaclesMemorization(int[][] obstacleGrid, int[][] dp, int row, int col) {
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1)
            return 1;
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];
        if (obstacleGrid[row][col] == 1)
            return 0;

        return uniquePathsWithObstaclesMemorization(obstacleGrid, dp, row, col + 1) + uniquePathsWithObstaclesMemorization(obstacleGrid, dp, row + 1, col);
    }

    /**
     * Dynamic Programming
     * Time: O(m*n)
     * * Space : O(m*n)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                dp[0][i] = 0;
            else
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int data = obstacleGrid[i][j];
                if (data == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }


    /**
     * Dynamic Programming
     * Time: O(m*n)
     * * Space : O(1)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesDPOptimized(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        obstacleGrid[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                obstacleGrid[0][i] = 0;
            else
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                obstacleGrid[i][0] = 0;
            else
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int data = obstacleGrid[i][j];
                if (data == 1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII obj = new UniquePathsII();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] matrix1 = {{0, 1}, {0, 0}};
        int[][] matrix2 = {{0, 0}};

        Utils.printHeadLine("Recursion");

        System.out.println(obj.uniquePathsWithObstaclesRecursion(matrix));
        System.out.println(obj.uniquePathsWithObstaclesRecursion(matrix1));
        System.out.println(obj.uniquePathsWithObstaclesRecursion(matrix2));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.uniquePathsWithObstaclesMemorization(matrix));
        System.out.println(obj.uniquePathsWithObstaclesMemorization(matrix1));
        System.out.println(obj.uniquePathsWithObstaclesMemorization(matrix2));

        Utils.printHeadLine("DP");
        System.out.println(obj.uniquePathsWithObstaclesDP(matrix));
        System.out.println(obj.uniquePathsWithObstaclesDP(matrix1));
        System.out.println(obj.uniquePathsWithObstaclesDP(matrix2));

        Utils.printHeadLine("DP Optimized");

        System.out.println(obj.uniquePathsWithObstaclesDPOptimized(matrix));
        System.out.println(obj.uniquePathsWithObstaclesDPOptimized(matrix1));
        System.out.println(obj.uniquePathsWithObstaclesDPOptimized(matrix2));
    }

}
