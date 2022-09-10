package com.matrix;
/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
public class NoOfIslands {
    /**
     * TIw
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int noOfIsland = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    markIsland(grid, i,j, visited);
                    noOfIsland++;
                }
            }

        }

        return noOfIsland;
    }

    private void markIsland(char[][] grid, int i, int j, boolean[][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j])
            return;
        visited[i][j] = true;
        markIsland(grid, i, j+1, visited);
        markIsland(grid, i, j-1, visited);
        markIsland(grid, i+1, j, visited);
        markIsland(grid, i-1, j, visited);
    }

    /**
     *
     */
    public int numIslands1(char[][] grid) {
        int noOfIsland = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    markIsland1(grid, i,j);
                    noOfIsland++;
                }
            }
        }

        return noOfIsland;
    }

    private void markIsland1(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        markIsland1(grid, i, j+1);
        markIsland1(grid, i, j-1);
        markIsland1(grid, i+1, j);
        markIsland1(grid, i-1, j);
    }
}
