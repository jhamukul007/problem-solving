package com.graph;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFSTraversal {

    List<Integer> bfsGraphResult = new ArrayList<>();

    public List<Integer> graphBFSTraversal(GraphNode graphNode) {
        List<Integer>[] adjacencyList = graphNode.adjacentVertices;
        boolean[] isVisited = new boolean[graphNode.vertexes + 1];
        for (int vertex = 1; vertex <= graphNode.vertexes; vertex++) {
            if (!isVisited[vertex]) {
                bfs(vertex, adjacencyList, isVisited);
            }
        }
        return bfsGraphResult;
    }

    public void bfs(int vertex, List<Integer>[] adjacencyList, boolean[] isVisited) {
        Queue<Integer> adjacencyQueue = new LinkedList<>();
        adjacencyQueue.add(vertex);
        isVisited[vertex] = true;
        while (!adjacencyQueue.isEmpty()) {
            vertex = adjacencyQueue.poll();
            bfsGraphResult.add(vertex);
            for (int v : adjacencyList[vertex]) {
                if (!isVisited[v]) {
                    isVisited[v] = true;
                    adjacencyQueue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphNode graph = new GraphNode(6);
        graph.addVertex(1, 2);
        graph.addVertex(1, 3);
        graph.addVertex(2, 1);
        graph.addVertex(2, 4);
        graph.addVertex(2, 5);
        graph.addVertex(3, 1);
        graph.addVertex(3, 5);
        graph.addVertex(4, 2);
        graph.addVertex(4, 5);
        graph.addVertex(4, 6);
        graph.addVertex(5, 2);
        graph.addVertex(5, 3);
        graph.addVertex(5, 4);
        graph.addVertex(5, 6);
        graph.addVertex(6, 4);
        graph.addVertex(6, 5);
        Utils.print(graph.adjacentVertices);
        GraphBFSTraversal obj = new GraphBFSTraversal();
        System.out.println(obj.graphBFSTraversal(graph));
    }

}
