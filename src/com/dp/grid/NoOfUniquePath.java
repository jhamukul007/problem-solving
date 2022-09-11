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
     * * Time 2^(m*n)
     * * Space : O(m*n)
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
     * * * Time 2^(m*n)
     * Top to bottom recursion
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

        // Moving Right direction                               // Moving Downward direction
        return totalNoOfUniquePath1(matrix, row, col + 1) + totalNoOfUniquePath1(matrix, row + 1, col);
    }

    /**
     * Time 2^(m*n)
     * Bottom up recursion Approach
     * *  Recursion on without global variable
     * *  When ever i add global variable, I won't be able to use Memorization
     */
    public int uniquePathsRecursionBottomUp(int m, int n) {
        int[][] matrix = new int[m][n];
        return uniquePathsRecursionBottomUp(matrix, m - 1, n - 1);
    }

    public int uniquePathsRecursionBottomUp(int[][] matrix, int row, int col) {
        if (row == 0 && col == 0)
            return 1;

        if (row < 0 || col < 0)
            return 0;


        // Moving Left direction                                       // Moving up direction
        return uniquePathsRecursionBottomUp(matrix, row, col - 1) + uniquePathsRecursionBottomUp(matrix, row - 1, col);
    }


    /**
     * Bottom up Memorization recursion Approach
     * *  Recursion on without global variable
     * *  When ever I add global variable, I won't be able to use Memorization
     */
    public int uniquePathsBottomUpMemorization(int m, int n) {
        int[][] matrix = new int[m][n];
        return uniquePathsRecursionBottomUp(matrix, m - 1, n - 1);
    }

    public int uniquePathsBottomUpMemorization(int[][] matrix, int row, int col) {

        if (row == 0 && col == 0)
            return 1;

        if (row < 0 || col < 0)
            return 0;

        if (matrix[row][col] != 0)
            return matrix[row][col];

        // Moving Left direction                                                               // Moving up direction
        return matrix[row][col] = uniquePathsBottomUpMemorization(matrix, row, col - 1) + uniquePathsBottomUpMemorization(matrix, row - 1, col);
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


    /**
     * * DP
     * * Time Complexity: O(m * n)
     * * Space : O(n) + O(n) = O(n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsDPSpaceOptimization(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;

        int[] currentRows = new int[n];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = (j - 1 < 0) ? 0 : currentRows[j - 1];
                int top = dp[j];
                currentRows[j] = left + top;
            }
            dp = currentRows;
            currentRows = new int[n];
        }
        return dp[n - 1];
    }

    /**
     * * DP
     * * Time Complexity: O(m * n)
     * * Space : O(n)
     * Replaced two array into single the same array dp stores old state as well
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsDPSpaceOptimization2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
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

        Utils.printHeadLine("Bottom up Recursion");
        System.out.println(obj.uniquePathsRecursionBottomUp(3, 3));
        System.out.println(obj.uniquePathsRecursionBottomUp(3, 7));
        System.out.println(obj.uniquePathsRecursionBottomUp(3, 2));

        Utils.printHeadLine("Bottom up memorization");
        System.out.println(obj.uniquePathsBottomUpMemorization(3, 3));
        System.out.println(obj.uniquePathsBottomUpMemorization(3, 7));
        System.out.println(obj.uniquePathsBottomUpMemorization(3, 2));

        Utils.printHeadLine("DP space optimized");
        System.out.println(obj.uniquePathsDPSpaceOptimization(3, 3));
        System.out.println(obj.uniquePathsDPSpaceOptimization(3, 7));
        System.out.println(obj.uniquePathsDPSpaceOptimization(3, 2));

        Utils.printHeadLine("DP space more optimized");
        System.out.println(obj.uniquePathsDPSpaceOptimization2(3, 3));
        System.out.println(obj.uniquePathsDPSpaceOptimization2(3, 7));
        System.out.println(obj.uniquePathsDPSpaceOptimization2(3, 2));
        
    }


}

