package com.matrix;

/**
 * 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrixDP {
    // Right, Left, Bottom, TOP
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        if (row == 0)
            return 0;
        int longestIncreasingPath = 0;
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                longestIncreasingPath = Math.max(longestIncreasingPath, longestIncreasingPath(matrix, i, j, temp));
            }
        }
        return longestIncreasingPath;
    }

    private int longestIncreasingPath(int[][] matrix, int i, int j, int[][] temp){
        if(temp[i][j] != 0)
            return temp[i][j];

        for(int[] dir : directions){
            int nextRow = i + dir[0];
            int nextCol = j + dir[1];

            if(nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length
                    ||  matrix[i][j] >= matrix[nextRow][nextCol])
                continue;
            temp[i][j] = Math.max(temp[i][j], longestIncreasingPath(matrix, nextRow, nextCol, temp));
        }
        return ++temp[i][j];
    }
}
