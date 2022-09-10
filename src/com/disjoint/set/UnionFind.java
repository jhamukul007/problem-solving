package com.disjoint.set;

import com.utils.Utils;

/**
 * Find time complexity : O(1)
 * isConnected time complexity : O(1)
 * union time complexity : O(n)
 */
public class UnionFind {

    int[] parents;

    public UnionFind(int vertexes) {
        parents = new int[vertexes];
        for (int i = 0; i < vertexes; i++)
            parents[i] = i;
    }

    /**
     * Time Complexity: O(1)
     *
     * @param vertex
     * @return
     */
    public int find(int vertex) {
        return parents[vertex];
    }

    /**
     * Time Complexity: O(n)
     *
     * @param u
     * @param v
     */
    public void union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);
        if (parentU != parentV) {
            for (int i = 0; i < parents.length; i++) {
                if (parents[i] == parentV)
                    parents[i] = parentU;
            }
        }
    }

    /**
     * Time Complexity: O(1)
     *
     * @param u
     * @param v
     * @return
     */
    public boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(5);
        unionFind.union(2, 4);
        unionFind.union(3, 4);
        unionFind.union(0, 2);
        System.out.println(unionFind.isConnected(0, 1));
        System.out.println(unionFind.isConnected(1, 4));
        System.out.println(unionFind.isConnected(0, 4));
        Utils.print(unionFind.parents);
    }

}
