package com.recursion;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    /**
     * Check if we can place the queen in the ROW, COL in the board or not
     *
     * @param row
     * @param col
     * @param board
     * @return
     */
    boolean canPlace(int row, int col, char[][] board) {
        if (row >= board.length || col >= board.length)
            return false;

        System.out.println("row: " + row + " and col : " + col);
        // Checking upper diagonal
        int i = row, j = col;
        while (j >= 0 && i >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        i = row;
        j = col;
        // Checking left vertical direction
        while (j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            j--;
        }
        j = col;
        // Checking in bottom diagonal diagonal
        while (i < board.length && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }
        return true;
    }

    public List<char[][]> nQueen(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<char[][]> result = new ArrayList<>();
        nQueenPlacement(0, result, board);
        return result;
    }

    void nQueenPlacement(int col, List<char[][]> result, char[][] board) {
        if (col == board.length) {
            result.add(copyResult(board));
        }

        for (int row = 0; row < board.length; row++) {
            if (canPlace(row, col, board)) {
                board[row][col] = 'Q';
                nQueenPlacement(col + 1, result, board);
                board[row][col] = '.';
            }
        }
    }

    char[][] copyResult(char[][] board) {
        char[][] copyBoard = new char[board.length][board.length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }
        return copyBoard;
    }


    public static void main(String[] args) {
        char[][] board = {{'Q', '.', '.'}, {'.', '.', 'Q'}, {'.', '.', '.'}};
        NQueen obj = new NQueen();
        List<char[][]> results = obj.nQueen(4);
        for (char[][] result : results) {
            System.out.println("---------****----------");
            Utils.print(result);
            System.out.println("---------****----------");
        }
    }

}
