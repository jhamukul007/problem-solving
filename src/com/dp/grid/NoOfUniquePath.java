package com.dp.grid;

import com.utils.Utils;

/**
 * * https://leetcode.com/problems/unique-paths/
 * * 62. Unique Paths
 */
public class NoOfUniquePath {

    int totalUniquePaths;

    /**
     * *  Recursion on global variable
     */
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        totalUniquePaths = 0;
        totalNoOfUniquePath(matrix, 0, 0);
        return totalUniquePaths;
    }

    public void totalNoOfUniquePath(int[][] matrix, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length)
            return;
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            //Operations
            totalUniquePaths += 1;
        }

        // Moving Right direction
        totalNoOfUniquePath(matrix, row, col + 1);
        // Moving Downward direction
        totalNoOfUniquePath(matrix, row + 1, col);
    }

    /**
     * *  Recursion on without global variable
     * * When ever i add global variable, I won't be able to use Memorization
     */
    public int uniquePaths1(int m, int n) {
        int[][] matrix = new int[m][n];
        // totalUniquePaths = 0;
        return totalNoOfUniquePath1(matrix, 0, 0);
        //return totalUniquePaths;
    }

    public int totalNoOfUniquePath1(int[][] matrix, int row, int col) {

        if (row >= matrix.length || col >= matrix[0].length)
            return 0;

        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            return 1;
        }

        // Moving Right direction
        return totalNoOfUniquePath1(matrix, row, col + 1) + totalNoOfUniquePath1(matrix, row + 1, col);

        // Moving Downward direction
    }


    /**
     * * Memorization
     * * Time Complexity: O(m * n)
     * * Space : O(m*n) -> Matrix
     * *         O(m * n) -> DP matrix
     * *         Stack - > O(m*n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsMemorization(int m, int n) {
        int[][] matrix = new int[m][n];
        int[][] dp = new int[m][n];
        return uniquePathsMemorization(matrix, dp, 0, 0);
    }

    private int uniquePathsMemorization(int[][] matrix, int[][] dp, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length)
            return 0;
        if (row == matrix.length - 1 && col == matrix[0].length - 1)
            return 1;
        if (dp[row][col] != 0)
            return dp[row][col];
        return dp[row][col] = uniquePathsMemorization(matrix, dp, row, col + 1) + uniquePathsMemorization(matrix, dp, row + 1, col);
    }


    /**
     * * Memorization Optimized
     * * Time Complexity: O(m * n)
     * * Space : O(m*n) -> Matrix
     * *         Stack - > O(m*n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsMemorizationOptimized(int m, int n) {
        int[][] matrix = new int[m][n];
        return uniquePathsMemorizationOptimized(matrix, 0, 0);
    }

    private int uniquePathsMemorizationOptimized(int[][] matrix, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length)
            return 0;
        if (row == matrix.length - 1 && col == matrix[0].length - 1)
            return 1;
        if (matrix[row][col] != 0)
            return matrix[row][col];
        return matrix[row][col] = uniquePathsMemorizationOptimized(matrix, row, col + 1) + uniquePathsMemorizationOptimized(matrix, row + 1, col);
    }


    /**
     * * DP
     * * Time Complexity: O(m * n)
     * * Space : O(m*n) -> Matrix
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsDP(int m, int n) {
        int[][] matrix = new int[m][n];
        int len = m > n ? m : n;
        for (int i = 0; i < len; i++) {
            if (i < m)
                matrix[i][0] = 1;
            if (i < n)
                matrix[0][i] = 1;
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Utils.printHeadLine("Recursion with global variable");
        NoOfUniquePath obj = new NoOfUniquePath();
        System.out.println(obj.uniquePaths(3, 3));
        System.out.println(obj.uniquePaths(3, 7));
        System.out.println(obj.uniquePaths(3, 2));

        Utils.printHeadLine("Recursion without global variable");
        System.out.println(obj.uniquePaths1(3, 3));
        System.out.println(obj.uniquePaths1(3, 7));
        System.out.println(obj.uniquePaths1(3, 2));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.uniquePathsMemorization(3, 3));
        System.out.println(obj.uniquePathsMemorization(3, 7));
        System.out.println(obj.uniquePathsMemorization(3, 2));

        Utils.printHeadLine("Memorization Optimized");
        System.out.println(obj.uniquePathsMemorizationOptimized(3, 3));
        System.out.println(obj.uniquePathsMemorizationOptimized(3, 7));
        System.out.println(obj.uniquePathsMemorizationOptimized(3, 2));

        Utils.printHeadLine("Dynamic Programming");
        System.out.println(obj.uniquePathsDP(3, 3));
        System.out.println(obj.uniquePathsDP(3, 7));
        System.out.println(obj.uniquePathsDP(3, 2));

    }

}

