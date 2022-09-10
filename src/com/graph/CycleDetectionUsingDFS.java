package com.graph;

import com.utils.Utils;

import java.util.List;

public class CycleDetectionUsingDFS {

    public static boolean isCycle(GraphNode graph) {
        List<Integer>[] adjacentNodes = graph.adjacentVertices;
        boolean[] isVisited = new boolean[graph.vertexes + 1];
        for (int vertex = 1; vertex <= graph.vertexes; vertex++) {
            if (!isVisited[vertex]) {
                if (isCycle(vertex, -1, adjacentNodes, isVisited))
                    return true;
            }
        }
        return false;
    }

    static boolean isCycle(int vertex, int prevVertex, List<Integer>[] adjacentNodes, boolean[] isVisited) {
        isVisited[vertex] = true;
        for (int nextVertex : adjacentNodes[vertex]) {
            if (!isVisited[nextVertex]) {
                if (isCycle(nextVertex, vertex, adjacentNodes, isVisited))
                    return true;
            } else if (nextVertex != prevVertex)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GraphNode graph = new GraphNode(4);
        graph.addVertex(1, 2);
        graph.addVertex(2, 1);
        graph.addVertex(2, 3);
        graph.addVertex(2, 4);
        graph.addVertex(3, 2);
        graph.addVertex(4, 2);
        Utils.print(graph.adjacentVertices);
        System.out.println(isCycle(graph));
    }
}
