package com.dp;

import com.utils.Utils;

/**
 * * https://leetcode.com/problems/cherry-pickup-ii/
 * * 1463. Cherry Pickup II
 */
public class CherryPickupII {

    int[] nextMove = {-1, 0, 1};

    /**
     * * Recursion
     * * Time: 3^n * 3^n
     * * Space : Stack space : O(m) -> No of rows
     *
     * @param grid
     * @return
     */
    public int cherryPickupRecursion(int[][] grid) {
        return cherryPickupRecursion(grid, 0, 0, grid[0].length - 1);
    }

    int cherryPickupRecursion(int[][] grid, int row, int col1, int col2) {
        if (col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length)
            return -1000000;
        if (row == grid.length - 1)
            return col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];
        int maxCollectedCandies = 0;
        for (int dx1 = 0; dx1 < nextMove.length; dx1++) {
            for (int dx2 = 0; dx2 < nextMove.length; dx2++) {
                int collected = (col1 == col2) ? grid[row][col1] : grid[row][col1] + grid[row][col2];
                collected += cherryPickupRecursion(grid, row + 1, col1 + nextMove[dx1], col2 + nextMove[dx2]);
                maxCollectedCandies = Math.max(maxCollectedCandies, collected);
            }
        }
        return maxCollectedCandies;
    }

    /**
     * * Memorization
     * * Time: 3^n * 3^n
     * * Space : Stack space : O(m) -> No of rows
     *
     * @param grid
     * @return
     */
    public int cherryPickupMemorization(int[][] grid) {
        int n = grid[0].length;
        int[][][] dp = new int[grid.length][n][n];
        return cherryPickupMemorization(grid, dp, 0, 0, grid[0].length - 1);
    }

    int cherryPickupMemorization(int[][] grid, int[][][] dp, int row, int col1, int col2) {

        if (col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length)
            return -1000000;
        if (row == grid.length - 1)
            return col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];
        if (dp[row][col1][col2] != 0)
            return dp[row][col1][col2];

        int maxCollectedCandies = 0;
        for (int dx1 = 0; dx1 < nextMove.length; dx1++) {
            for (int dx2 = 0; dx2 < nextMove.length; dx2++) {
                int collected = (col1 == col2) ? grid[row][col1] : grid[row][col1] + grid[row][col2];
                collected += cherryPickupMemorization(grid, dp, row + 1, col1 + nextMove[dx1], col2 + nextMove[dx2]);
                maxCollectedCandies = Math.max(maxCollectedCandies, collected);
            }
        }
        return dp[row][col1][col2] = maxCollectedCandies;
    }


    public static void main(String[] args) {

        CherryPickupII obj = new CherryPickupII();

        int[][] matrix = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        int[][] matrix1 = {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}};


        Utils.printHeadLine("Recursion");
        System.out.println(obj.cherryPickupRecursion(matrix));
        System.out.println(obj.cherryPickupRecursion(matrix1));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.cherryPickupMemorization(matrix));
        System.out.println(obj.cherryPickupMemorization(matrix1));
    }

}
