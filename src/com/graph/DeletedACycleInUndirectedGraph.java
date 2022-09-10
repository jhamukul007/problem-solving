package com.graph;

import com.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeletedACycleInUndirectedGraph {

    public static boolean isCycleInUndirectedGraph(GraphNode node) {
        List<Integer>[] adjacencyList = node.adjacentVertices;
        boolean[] isVisited = new boolean[node.vertexes + 1];
        for (int vertex = 1; vertex <= node.vertexes; vertex++) {
            if (!isVisited[vertex]) {
                if(isCycle(vertex, adjacencyList, isVisited))
                    return true;
            }
        }
        return false;
    }

    static boolean isCycle(int vertex, List<Integer>[] adjacencyList, boolean[] isVisited) {
        Queue<VertexDetails> bfsQueue = new LinkedList<>();
        bfsQueue.add(new VertexDetails(vertex, -1));
        isVisited[vertex] = true;

        while (!bfsQueue.isEmpty()) {
            VertexDetails currentVertex = bfsQueue.poll();
            for (int adjacencyVertex : adjacencyList[currentVertex.weight]) {
                if (!isVisited[adjacencyVertex]) {
                    bfsQueue.add(new VertexDetails(adjacencyVertex, currentVertex.weight));
                    isVisited[adjacencyVertex] = true;
                } else if (currentVertex.previous != adjacencyVertex)
                    return true;
            }
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
        System.out.println(isCycleInUndirectedGraph(graph));
        GraphNode graph1 = new GraphNode(6);
        graph1.addVertex(1, 2);
        graph1.addVertex(1, 3);
        graph1.addVertex(2, 1);
        graph1.addVertex(2, 4);
        graph1.addVertex(2, 5);
        graph1.addVertex(3, 1);
        graph1.addVertex(3, 5);
        graph1.addVertex(4, 2);
        graph1.addVertex(4, 5);
        graph1.addVertex(4, 6);
        graph1.addVertex(5, 2);
        graph1.addVertex(5, 3);
        graph1.addVertex(5, 4);
        graph1.addVertex(5, 6);
        graph1.addVertex(6, 4);
        graph1.addVertex(6, 5);
        System.out.println(isCycleInUndirectedGraph(graph1));


    }
}

class VertexDetails {
    public int weight;
    public int previous;

    public VertexDetails(int weight, int previous) {
        this.weight = weight;
        this.previous = previous;
    }
}