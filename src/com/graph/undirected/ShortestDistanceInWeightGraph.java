package com.graph.undirected;

import com.utils.Utils;
import com.utils.graph.weighted.WeightedGraphNode;
import com.utils.pairs.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Dijkstra algorithm
 */
public class ShortestDistanceInWeightGraph {

    public int[] shortestDistance(WeightedGraphNode weightedGraphNode, int source) {
        int[] shortestDistance = new int[weightedGraphNode.vertexes];
        for (int i = 0; i < shortestDistance.length; i++)
            shortestDistance[i] = Integer.MAX_VALUE;
        shortestDistance[source] = 0;
        calculateShortestDistance(weightedGraphNode, shortestDistance, source);
        return shortestDistance;
    }

    public void calculateShortestDistance(WeightedGraphNode weightedGraphNode, int[] shortestDistance, int source) {
        // Pair: key as vertex and value as distance
        // Min PriorityQueue so always pick minimum distance
        PriorityQueue<Pair<Integer, Integer>> minDistanceHeap = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        minDistanceHeap.add(new Pair<>(source, 0));
        while (!minDistanceHeap.isEmpty()) {
            Pair<Integer, Integer> vertex = minDistanceHeap.poll();
            int prevDistance = vertex.getValue();
            for (Pair<Integer, Integer> adjacentVertex : weightedGraphNode.adjacencyList[vertex.getKey()]) {
                if (adjacentVertex.getValue() + prevDistance < shortestDistance[adjacentVertex.getKey()]) {
                    shortestDistance[adjacentVertex.getKey()] = adjacentVertex.getValue() + prevDistance;
                    minDistanceHeap.add(new Pair<>(adjacentVertex.getKey(), adjacentVertex.getValue() + prevDistance));
                }
            }
        }
    }

    public static void main(String[] args) {
        ShortestDistanceInWeightGraph obj = new ShortestDistanceInWeightGraph();
        WeightedGraphNode wgn1= new WeightedGraphNode(5,true);

        wgn1.addEdgeWithWeight(0,1,2);
        wgn1.addEdgeWithWeight(0,3,1);

        wgn1.addEdgeWithWeight(1,0,2);
        wgn1.addEdgeWithWeight(1,2,4);
        wgn1.addEdgeWithWeight(1,4,5);

        wgn1.addEdgeWithWeight(1,4,5);
//        WeightedGraphNode weightedGraphNode1 = new WeightedGraphNode(6, true);rue
//        weightedGraphNode1.addEdgeWithWeight(0, 1, 1);
//        weightedGraphNode1.addEdgeWithWeight(0, 4, 3);
//
//        weightedGraphNode1.addEdgeWithWeight(1, 2, 2);
//
//        weightedGraphNode1.addEdgeWithWeight(2, 3, 6);
//
//        weightedGraphNode1.addEdgeWithWeight(4, 2, 6);
//        weightedGraphNode1.addEdgeWithWeight(4, 5, 9);
//
//        weightedGraphNode1.addEdgeWithWeight(5, 3, 5);
//        Utils.print(obj.shortestDistance(weightedGraphNode1,0));
    }
}
