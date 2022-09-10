package com.utils;

import java.util.LinkedList;

public class Graph {

    public int noOfVertex;
    public LinkedList<Integer> adjacentVertices[];

    public Graph(int noOfVertex){
        this.noOfVertex = noOfVertex;
        adjacentVertices = new LinkedList[noOfVertex+1];
        for(int i = 1; i < noOfVertex;i++){
            adjacentVertices[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int w){
       this.adjacentVertices[vertex].add(w);
    }
}
