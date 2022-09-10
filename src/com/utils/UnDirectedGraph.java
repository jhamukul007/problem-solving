package com.utils;

import java.util.ArrayList;
import java.util.List;

public class UnDirectedGraph {
    public int vertexes;
    public List<Integer>[] adjacentVertices;

    public UnDirectedGraph(int vertexes){
        this.vertexes = vertexes;
        adjacentVertices = new List[vertexes+1];
        for(int i = 1; i <= vertexes; i++){
            adjacentVertices[i] = new ArrayList<>();
        }
    }
}
