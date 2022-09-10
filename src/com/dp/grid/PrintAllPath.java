package com.dp.grid;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPath {

    /**
     * * Print all path from (0,0) to (m-1, n-1)
     * Movement : Right and down
     *
     * @param matrix
     */
    public void printAllPath(int[][] matrix) {
        printAllPathRecursive(matrix, 0, 0, new ArrayList<>());
    }

    void printAllPathRecursive(int[][] matrix, int row, int col, List<Integer> result) {
        if (col >= matrix[0].length || row >= matrix.length)
            return;

        result.add(matrix[row][col]);

        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            Utils.printItr(result);
            result.remove(result.size() - 1);
            System.out.println();
            return;
        }

        // Move Right
        printAllPathRecursive(matrix, row, col + 1, result);
        // result.remove(result.size() - 1);
        // Move Down
        printAllPathRecursive(matrix, row + 1, col, result);
        result.remove(result.size() - 1);
    }

    /**
     * * Print all path from (0,0) to (m-1, n-1)
     * Movement : Right and down and Diagonal
     *
     * @param matrix
     */
    public void printAllPath2(int[][] matrix) {
        printAllPath2(matrix, 0, 0, new ArrayList<>());
    }

    public void printAllPath2(int[][] matrix, int row, int col, List<Integer> result) {
        if (row >= matrix.length || col >= matrix[0].length)
            return;
        result.add(matrix[row][col]);
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            Utils.printItr(result);
            System.out.println();
            result.remove(result.size() - 1);
            return;
        }
        // Right Movement
        printAllPath2(matrix, row, col + 1, result);
        // Down Movement
        printAllPath2(matrix, row + 1, col, result);

        // Diagonal Movement
        printAllPath2(matrix, row + 1, col + 1, result);

        result.remove(result.size() - 1);
    }

    public static void main(String[] args) {
        PrintAllPath obj = new PrintAllPath();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        obj.printAllPath2(matrix);
    }
}


//1 2 3
//4 5 6
//7 8 9
