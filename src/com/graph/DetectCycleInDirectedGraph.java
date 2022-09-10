package com.graph;

import java.util.List;

public class DetectCycleInDirectedGraph {
    /**
     * Time Complexcity:O(v+e)
     * @param node
     * @return
     */
    public boolean isCycle(GraphNode node){
        boolean[] visitedArr = new boolean[node.vertexes+1];
        boolean[] dfsVisitedArr = new boolean[node.vertexes+1];
        for(int vertex = 1; vertex <= node.vertexes; vertex++){
            if(!visitedArr[vertex]){
                if(isCycle(vertex, node.adjacentVertices, visitedArr, dfsVisitedArr))
                    return true;
            }
        }
        return false;
    }

    boolean isCycle(int currentVertex, List<Integer>[] adjacentVertex,  boolean[] visitedArr, boolean[] dfsVisitedArr){
        visitedArr[currentVertex] = true;
        dfsVisitedArr[currentVertex] = true;
        for(int nextVertexes : adjacentVertex[currentVertex]){
            if(!visitedArr[nextVertexes]){
                if(isCycle(nextVertexes, adjacentVertex, visitedArr, dfsVisitedArr))
                   return true;
            }
            else if(dfsVisitedArr[nextVertexes]){
                return true;
            }
        }
        dfsVisitedArr[currentVertex] = false;
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph obj = new DetectCycleInDirectedGraph();
        GraphNode graphNode = new GraphNode(5);
        graphNode.addEdge(1, 2);
        graphNode.addEdge(2, 3);
        graphNode.addEdge(3, 4);
        graphNode.addEdge(4, 5);
        System.out.println(obj.isCycle(graphNode));
    }
}
