package com.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int vertexes;
    public List<Integer> adjacentVertices[];

    public GraphNode(int vertexes){
        this.vertexes = vertexes;
        adjacentVertices = new List[vertexes+1];
        for(int i = 1; i <= vertexes; i++){
            adjacentVertices[i] = new ArrayList<>();
        }
    }

    public GraphNode(int vertexes, boolean zeroVertices){
        if(zeroVertices){
            this.vertexes = vertexes;
            adjacentVertices = new List[vertexes];
            for(int i = 0; i < vertexes; i++){
                adjacentVertices[i] = new ArrayList<>();
            }
        }
        else
            new GraphNode(vertexes);
    }

    /**
     * Adding parentVertex-1 vertex
     * @param parentVertex
     * @param childVertex
     */
    public void addVertex(int parentVertex, int childVertex){
        adjacentVertices[parentVertex].add(childVertex);
    }
    public void addEdge(int fromVertex, int toVertex){
        addVertex(fromVertex, toVertex);
    }
}
