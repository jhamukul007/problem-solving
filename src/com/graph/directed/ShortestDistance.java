package com.graph.directed;

import com.utils.Utils;
import com.utils.graph.weighted.WeightedGraphNode;
import com.utils.pairs.Pair;

import java.util.List;
import java.util.Stack;

public class ShortestDistance {
    /**
     * Find topology sort of graph
     */

    public Stack<Integer> topologySort(WeightedGraphNode weightedGraphNode) {
        Stack<Integer> topologySort = new Stack<>();
        boolean[] visited = new boolean[weightedGraphNode.vertexes];
        for (int i = 0; i < weightedGraphNode.vertexes; i++) {
            if (!visited[i]) {
                dfsTraversal(weightedGraphNode.adjacencyList, i, visited, topologySort);
            }
        }
        return topologySort;
    }

    public void dfsTraversal(List<Pair<Integer, Integer>>[] adjacencyList, int currentVertex, boolean[] visited, Stack<Integer> result) {
        if (visited[currentVertex]) return;
        visited[currentVertex] = true;
        for (Pair<Integer, Integer> adjacencyVertex : adjacencyList[currentVertex]) {
            if (!visited[adjacencyVertex.getKey()])
                dfsTraversal(adjacencyList, adjacencyVertex.getKey(), visited, result);
        }
        result.push(currentVertex);
    }

    public int[] shortestDistance(int sourceVertex, WeightedGraphNode weightedGraphNode) {
        int[] shortestDistanceArr = new int[weightedGraphNode.vertexes];
        for (int i = 0; i < weightedGraphNode.vertexes; i++)
            shortestDistanceArr[i] = Integer.MAX_VALUE;

        shortestDistanceArr[sourceVertex] = 0;
        Stack<Integer> topologySort = topologySort(weightedGraphNode);
        while (!topologySort.isEmpty()) {
            int vertex = topologySort.pop();
            // int weight = ;

            if (shortestDistanceArr[vertex] != Integer.MAX_VALUE) {
                for (Pair<Integer, Integer> adjacencyVertex : weightedGraphNode.adjacencyList[vertex]) {
                    if (adjacencyVertex.getValue() + shortestDistanceArr[vertex] < shortestDistanceArr[adjacencyVertex.getKey()]) {
                        shortestDistanceArr[adjacencyVertex.getKey()] = adjacencyVertex.getValue() + shortestDistanceArr[vertex];
                    }
                }
            }
        }
        return shortestDistanceArr;
    }

    public static void main(String[] args) {
        ShortestDistance obj = new ShortestDistance();
//        WeightedGraphNode weightedGraphNode = new WeightedGraphNode(7, true);
//        weightedGraphNode.addEdgeWithWeight(0,1,5);
//
//        weightedGraphNode.addEdgeWithWeight(1,2,3);
//        weightedGraphNode.addEdgeWithWeight(1,3,1);
//
//        weightedGraphNode.addEdgeWithWeight(2,5,2);
//        weightedGraphNode.addEdgeWithWeight(2,6,4);
//
//        weightedGraphNode.addEdgeWithWeight(3,4,1);
//
//        weightedGraphNode.addEdgeWithWeight(4,6,2);
//        weightedGraphNode.addEdgeWithWeight(5,6,3);

        WeightedGraphNode weightedGraphNode1 = new WeightedGraphNode(6, true);
        weightedGraphNode1.addEdgeWithWeight(0, 1, 1);
        weightedGraphNode1.addEdgeWithWeight(0, 4, 3);

        weightedGraphNode1.addEdgeWithWeight(1, 2, 2);

        weightedGraphNode1.addEdgeWithWeight(2, 3, 6);

        weightedGraphNode1.addEdgeWithWeight(4, 2, 6);
        weightedGraphNode1.addEdgeWithWeight(4, 5, 9);

        weightedGraphNode1.addEdgeWithWeight(5, 3, 5);

        Utils.printWeightedGraph(weightedGraphNode1.adjacencyList);

        Utils.print(obj.shortestDistance(0, weightedGraphNode1));
    }
}
//[ 0, 1, 3, 9, 3, 12,  ]