package com.graph.undirected;

import com.graph.GraphNode;
import com.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find Shortest distance between source to destination
 */
public class ShortestDistance {
    /**
     * Algo:
     * Step 1: Create an array of size graph vertexes : shortestDistance
     * Step 2: Initialize the array with  Integer.MAX_VALUE
     * Step 3: Create a queue
     * Step 4: Insert source vertex into queue and change value of shortestDistance on index source that is shortestDistance[sourceVertex] = 0
     * Step 5: Run the while till queue is not empty
     * Step 6: Pop from the queue and check minimum distance of popped vertex from shortestDistance by shortestDistance[poppedVertex];
     * step 7: Iterate all adjacentVertex of the popped vertex and check the distance of the adjacentVertex is lesser by considering Popped vertex by
     * ie minDistance + 1 < shortestDistance[adjacentVertex]
     * step 8: if minDistance + 1 < shortestDistance[adjacentVertex] is true repeat step 7
     * step 9 : Repeat step 5 unless util stack is not empty
     * step 10: shortestDistance is the shortest Distance array from the source vertex.
     */
    int[] shortestDistance;

    public void shortestDistance(GraphNode graph, int source) {
        shortestDistance = new int[graph.vertexes];
        for (int i = 0; i < shortestDistance.length; i++)
            shortestDistance[i] = Integer.MAX_VALUE;
        bfs(graph.adjacentVertices, source);
    }

    public void bfs(List<Integer>[] adjacentVertices, int currentVertices) {

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.offer(currentVertices);
        shortestDistance[currentVertices] = 0;
        while (!bfsQueue.isEmpty()) {
            int vertex = bfsQueue.poll();
            int minDistance = shortestDistance[vertex];

            for (int adjacentVertex : adjacentVertices[vertex]) {
                if (minDistance + 1 < shortestDistance[adjacentVertex]) {
                    bfsQueue.offer(adjacentVertex);
                    shortestDistance[adjacentVertex] = minDistance + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        ShortestDistance obj = new ShortestDistance();
        GraphNode graph = new GraphNode(8, true);
        graph.addEdge(0, 1);
        
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        
        graph.addEdge(2, 1);
        graph.addEdge(2, 6);    
        
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
       
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);

        graph.addEdge(6, 2);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);

        graph.addEdge(7, 6);
        
        Utils.print(graph.adjacentVertices);
        obj.shortestDistance(graph, 1);
        Utils.print(obj.shortestDistance);
    }
}
