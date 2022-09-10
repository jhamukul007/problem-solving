package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Kahn's algorithm
 */
public class TopologicalGraphSortBFS {

    public List<Integer> topologicalSort(GraphNode graphNode){
        //In degree of a node
        int[] inDegrees = new int[graphNode.vertexes];

        for(int i = 0 ; i < graphNode.vertexes; i++) {
            for (int data : graphNode.adjacentVertices[i]){
                inDegrees[data]++;
            }
        }
        List<Integer> topologicalSort = new ArrayList<>();
        // Storing zero in degree vertex in the queue
        Queue<Integer> bfsDataQueue = new LinkedList<>();

        for(int i = 0; i < inDegrees.length; i++){
            if(inDegrees[i] == 0)
                bfsDataQueue.offer(i);
        }

        while(!bfsDataQueue.isEmpty()){
            int inZeroVertex = bfsDataQueue.poll();
            topologicalSort.add(inZeroVertex);
            for(int adjacentVertex : graphNode.adjacentVertices[inZeroVertex]){
                inDegrees[adjacentVertex]--;
                if(inDegrees[adjacentVertex] == 0)
                    bfsDataQueue.offer(adjacentVertex);
            }
        }
        return topologicalSort;
    }

    /*
        Algo
        steps 1: Initialize an array inDegrees to store in degree of any vertex.
        steps 2: store in-degree of a vertex into inDegrees(array)
        steps 3: Initialize a Queue (bfsDataQueue)
        steps 4: Initialize a List(topologicalSortedList) that will take care of resultant topological Sort
        steps 4: Add vertex with zero inDegree into Queue (bfsDataQueue)
        steps 5: Iterate the queue(bfsDataQueue) while queue is not empty.
             steps 6: pop vertex from the queue(bfsDataQueue).
             steps 7: insert vertex into resultant list (topologicalSortedList).
             steps 8: loop through adjacent vertexes of popped vertex.
                  steps 9: decrease in-degree of an iterated vertex by 1.
                  steps 10: check if iterated vertex in-degree is zero, insert into queue(bfsDataQueue)
        steps 11: return  List(topologicalSortedList)
     */

    public static void main(String[] args) {
        TopologicalGraphSortBFS obj = new TopologicalGraphSortBFS();
        GraphNode graph = new GraphNode(6, true );
        graph.addVertex(2, 3);
        graph.addVertex(3, 1);
        graph.addVertex(4, 0);
        graph.addVertex(4, 1);
        graph.addVertex(5, 0);
        graph.addVertex(5, 2);
       // System.out.println(obj.topologicalSort(graph));

        GraphNode graph1 = new GraphNode(6, true);
        graph1.addVertex(0, 1);
        graph1.addVertex(1, 2);
        graph1.addVertex(2, 3);
        graph1.addVertex(3, 4);
        graph1.addVertex(3, 5);
        graph1.addVertex(4, 2);
        System.out.println(obj.topologicalSort(graph1));
    }
}
