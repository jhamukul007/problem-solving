package com.disjoint.set;

public class DisJointSetQuick {
    int[] parents;
    int[] ranks;

    public DisJointSetQuick(int vertexes) {
        parents = new int[vertexes];
        ranks = new int[vertexes];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public void union(int u, int v) {
        int parentU = parents[u];
        int parentV = parents[v];
        int rankU = ranks[parentU];
        int rankV = ranks[parentV];
        if (parentU == parentV)
            return;

        if (rankU > rankV)
            parents[parentV] = parentU;
        else if (rankV > rankU)
            parents[parentU] = parentV;
        else {
            parents[parentV] = parentU;
            ranks[parentU]++;
        }
    }

    public int find(int u) {
        if (u == parents[u])
            return u;
        return parents[u] = find(parents[u]);
    }

    public boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }

    public static void main(String[] args) {
        DisJointSetQuick uf = new DisJointSetQuick(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.isConnected(1, 5)); // true
        System.out.println(uf.isConnected(5, 7)); // true
        System.out.println(uf.isConnected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.isConnected(4, 9)); // true
    }
}
