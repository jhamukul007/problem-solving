package com.disjoint.set;

import com.utils.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/featured/card/graph/618/disjoint-set/3845/
 * Number of Provinces
 */
public class NumberOfProvinces {

    int[] ranks;
    int[] parents;
    int count;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        count = n;
        ranks = new int[n];
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (isConnected[i][j] == 1)
                    union(i, j);
            }
        }
        Utils.print(parents);
        // Taking extra O(n) space and O(n) time
//        Set<Integer> uniqueParents = new HashSet<>();
//        for(int i = 0; i < n; i++)
//            uniqueParents.add(findParent(i));
//        return uniqueParents.size();
        return count;
    }

    void union(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);
        if (parentU == parentV)
            return;
        if (ranks[parentU] > ranks[parentV])
            parents[parentV] = parentU;
        else if (ranks[parentV] > ranks[parentU])
            parents[parentU] = parentV;
        else {
            parents[parentV] = parentU;
            ranks[parentU]++;
        }
        count--;
    }

    int findParent(int u){
        if(u == parents[u])
            return u;
        return parents[u] = findParent(parents[u]);
    }

    public static void main(String[] args) {
        NumberOfProvinces obj = new NumberOfProvinces();
        int[][] matrix = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] matrix1 =  {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        int[][] matrix2 = {{1,0,0,0,1,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,1,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,0,1,0,0,0,1,1,0,0},{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,1,1,0,0,1,1,0,0,1},{0,0,0,0,1,1,0,1,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,1}};
        System.out.println(obj.findCircleNum(matrix2));
    }


}
