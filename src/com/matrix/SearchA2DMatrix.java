package com.matrix;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 74. Search a 2D Matrix
 * https://jamboard.google.com/d/1fJRwajJgpXXNwbcpM1xQ1RxmcyY0UvMS-yWtI0uTEd4/viewer?f=0
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int currentRow = 0;
        int currentcolumn = columns-1;
        while(currentRow < rows && currentcolumn >= 0){
            if(matrix[currentRow][currentcolumn] == target)
                return true;
            if(target < matrix[currentRow][currentcolumn])
                currentcolumn--;
            else
                currentRow++;
        }
        return false;
    }

    public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if(rows == 1 && columns == 1)
            return matrix[0][0] == target;
        int start = 0;
        int end = rows* columns - 1;
        while(start <= end){
            int mid = (start + end)/2;
            int midData = matrix[mid/columns][mid%columns];
            if(midData == target)
                return true;
            if(target > midData)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }
}
