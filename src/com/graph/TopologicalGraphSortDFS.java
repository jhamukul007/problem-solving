package com.graph;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalGraphSortDFS {

    public List<Integer> topologicalSort(GraphNode graphNode){
        boolean[] visited = new boolean[graphNode.vertexes];
        Stack<Integer> topologicalSorted = new Stack<>();
        for(int vertex = 0; vertex < graphNode.vertexes ; vertex++){
            if(!visited[vertex])
                topologySort(vertex, graphNode.adjacentVertices, visited, topologicalSorted);
        }
        List<Integer> result = new ArrayList<>();
        topologicalSorted.stream().forEach(vertex -> result.add(vertex));
        return result;
    }

    void topologySort(int currentVertex, List<Integer>[] adjacentList, boolean[] visited, Stack<Integer> topologicalSorted){
        visited[currentVertex] = true;

        for(int nextVertex : adjacentList[currentVertex]){
            if(!visited[nextVertex]){
                topologySort(nextVertex, adjacentList,visited, topologicalSorted);
            }
        }
        topologicalSorted.push(currentVertex);
    }

    public static void main(String[] args) {
        TopologicalGraphSortDFS obj = new TopologicalGraphSortDFS();
        GraphNode graphNode = new GraphNode(6, true);
        graphNode.addEdge(5,0);
        graphNode.addEdge(5,2);
        graphNode.addEdge(2,3);
        graphNode.addEdge(3,1);
        graphNode.addEdge(4,0);
        graphNode.addEdge(4,1);
      //  Utils.print(graphNode.adjacentVertices);
        System.out.println(obj.topologicalSort(graphNode));
    }

}
