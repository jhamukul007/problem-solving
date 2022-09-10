package com.disjoint.set;

public class DisjointSetBasic {
    int[] parentVertex;

    public DisjointSetBasic(int vertexes) {
        parentVertex = new int[vertexes];
        for (int i = 0; i < parentVertex.length; i++)
            parentVertex[i] = i;
    }

    public void union(int u, int v) {
        int parentU = parentVertex[u];
        int parentV = parentVertex[v];
    }

    boolean isConnected(int u, int v) {
        return parent(u) == parent(v);
    }

    int parent(int vertex) {
        int currentParent = parentVertex[vertex];
        while (currentParent != parentVertex[currentParent]) {
            currentParent = parentVertex[currentParent];
        }
        return currentParent;
    }
}
