package com.disjoint.set;

import com.utils.Utils;

public class QuickUnion {
    int[] parents;

    public QuickUnion(int vertexes) {
        parents = new int[vertexes];
        for (int i = 0; i < vertexes; i++)
            parents[i] = i;
    }

    public void union(int u, int v) {
        int parentU = parents[u];
        int parentV = parents[v];
        if (parentU != parentV)
            parents[parentV] = parentU;
    }

    public int find(int u) {
        int parentU = parents[u];
        while (parentU != parents[parentU]) {
            parentU = parents[parentU];
        }
        return parentU;
    }

    boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }

    public static void main(String[] args) {
        QuickUnion union = new QuickUnion(7);
        union.union(0,1);
        union.union(1,2);
        union.union(1,3);
        union.union(4,5);
        union.union(4,6);
        union.union(1,5);
        Utils.print(union.parents);
       System.out.println(union.find(6));
    }

}
