package com.matrix;

/**
 * 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrix {
    /**
     * BackTracking but not solution need to optimize
     */
    int[][] directions = {{0,1},{0,-1}, {1,0} ,{-1,0}};
    int[][] matrix = null;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        this.matrix = matrix;
        int maxIncreasingPath = 0;

        for(int i = 0; i < matrix.length; ++i)
            for(int j = 0; j < matrix[0].length; ++j)
                maxIncreasingPath = Math.max(maxIncreasingPath,  dfs(i, j));

        return maxIncreasingPath;
    }

    int dfs(int i, int j){
        int maxIncreasingPath = 0;
        for(int[] dir : directions){
            int tempI = i + dir[0];
            int tempJ = j + dir[1];
            if(tempI >= 0 && tempI < matrix.length&& tempJ >= 0 && tempJ < matrix[0].length && matrix[tempI][tempJ] > matrix[i][j]  )
                maxIncreasingPath = Math.max(maxIncreasingPath, dfs(tempI, tempJ));
        }
        return ++maxIncreasingPath;
    }



    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        LongestIncreasingPathInAMatrix obj = new LongestIncreasingPathInAMatrix();
        System.out.println(obj.longestIncreasingPath(matrix));
    }
}
