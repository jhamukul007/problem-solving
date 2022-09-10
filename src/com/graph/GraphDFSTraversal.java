package com.graph;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GraphDFSTraversal {
    List<Integer> dfsTraversalResult = new ArrayList<>();

    public List<Integer> graphDfsTraversal(GraphNode graphNode) {
        List<Integer>[] adjacencyList = graphNode.adjacentVertices;
        boolean[] isVisited = new boolean[graphNode.vertexes + 1];
        for (int vertex = 1; vertex <= graphNode.vertexes; vertex++) {
            if (!isVisited[vertex]) {
                dfsTraversal(vertex, adjacencyList, isVisited);
            }
        }
        return dfsTraversalResult;
    }

    public void dfsTraversal(int vertex, List<Integer>[] adjacencyList, boolean[] isVisited) {
        if (isVisited[vertex])
            return;
        isVisited[vertex] = true;
        dfsTraversalResult.add(vertex);
        for (int v : adjacencyList[vertex]) {
            if (!isVisited[v]) {
                dfsTraversal(v, adjacencyList, isVisited);
            }
        }

    }

    public static void main(String[] args) {
        GraphNode graph = new GraphNode(7);
        graph.addVertex(1, 2);
        graph.addVertex(2, 1);
        graph.addVertex(2, 4);
        graph.addVertex(2, 7);
        graph.addVertex(3, 5);
        graph.addVertex(4, 2);
        graph.addVertex(4, 6);
        graph.addVertex(5, 3);
        graph.addVertex(6, 4);
        graph.addVertex(6, 7);
        graph.addVertex(7, 2);
        graph.addVertex(7, 6);
        GraphDFSTraversal obj = new GraphDFSTraversal();
        System.out.println(obj.graphDfsTraversal(graph));
        Utils.print(graph.adjacentVertices);
    }
}
