package com.dp.grid;

import com.utils.MatrixUtil;
import com.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * * https://leetcode.com/problems/triangle/
 * 120. Triangle
 */
public class Triangle {

    /**
     * * Recursion
     * * Time: 2 ^(m*n)
     * * Space :
     *
     * @param triangle
     * @return
     */
    public int minPathSumRecursion(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        return minPathSumRecursion(triangle, 0, 0);
    }

    public int minPathSumRecursion(List<List<Integer>> triangle, int row, int col) {
        if (row >= triangle.size() || col >= triangle.get(row).size())
            return 0;

        int downSum = triangle.get(row).get(col) + minPathSumRecursion(triangle, row + 1, col);
        int diagonalSum = triangle.get(row).get(col) + minPathSumRecursion(triangle, row + 1, col + 1);
        return Math.min(downSum, diagonalSum);
    }

    /**
     * * Memorization
     * * Time: 2 ^(m*n)
     * * Space :
     *
     * @param triangle
     * @return
     */
    public int minPathSumRecursionMemorization(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int[][] dp = new int[triangle.size()][triangle.size()];
        MatrixUtil.fill(dp, -1);
        int result = minPathSumRecursionMemorization(triangle, triangle.size(), dp, 0, 0);
        Utils.print(dp);
        return result;
    }

    public int minPathSumRecursionMemorization(List<List<Integer>> triangle, int n, int[][] dp, int row, int col) {
        if (row == n - 1)
            return triangle.get(n-1).get(col);
        if (dp[row][col] != -1)
            return dp[row][col];

        int downSum = triangle.get(row).get(col) + minPathSumRecursionMemorization(triangle, n, dp, row + 1, col);
        int diagonalSum = triangle.get(row).get(col) + minPathSumRecursionMemorization(triangle, n, dp, row + 1, col + 1);
        return dp[row][col] = Math.min(downSum, diagonalSum);
    }


    /**
     * * Dynamic Programming
     * * Time: O(n*m)
     * * Space : O(1)
     * * Space:
     *
     * @param triangle
     * @return
     */
    public int minPathSumDP(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {

                int diagonal = j - 1 < 0 ? Integer.MAX_VALUE : triangle.get(i - 1).get(j - 1);
                int up = triangle.get(i - 1).size() <= j ? Integer.MAX_VALUE : triangle.get(i - 1).get(j);
                int totalCost = triangle.get(i).get(j) + Math.min(diagonal, up);
                triangle.get(i).set(j, totalCost);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int cost : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, cost);
        }
        return min;
    }

    public static void main(String[] args) {
        Triangle obj = new Triangle();
        //[2],[3,4],[6,5,7],[4,1,8,3]
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        //List<List<Integer>> triangle1 = List.of(List.of(1), List.of(2, 3), List.of(4, 5, 6), List.of(7, 8, 9, 10));

        Utils.printHeadLine("Recursion");
        System.out.println(obj.minPathSumRecursion(triangle));
        //System.out.println(obj.minPathSumRecursion(triangle1));

        Utils.printHeadLine("Dynamic Programming");
        System.out.println(obj.minPathSumDP(triangle));
        //System.out.println(obj.minPathSumDP(triangle1));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.minPathSumRecursionMemorization(triangle));
    }
}


