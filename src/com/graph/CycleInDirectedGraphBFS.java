package com.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Using kahn's algorithm
 */
public class CycleInDirectedGraphBFS {

    public boolean isCycle(GraphNode graphNode){
       int[] inDegreeArr = new int[graphNode.vertexes];
       for(int i = 0; i < graphNode.vertexes; i++){
           for(int vertex : graphNode.adjacentVertices[i]){
               inDegreeArr[vertex]++;
           }
       }
       Queue<Integer> bfsZeroInDegreeQueue = new LinkedList<>();
       for(int i = 0; i < inDegreeArr.length; i++){
           if(inDegreeArr[i] == 0)
               bfsZeroInDegreeQueue.offer(i);
       }
       int topologicalVertexCount = 0;
       while(!bfsZeroInDegreeQueue.isEmpty()){
           topologicalVertexCount++;
           for(int adjacentVertex:  graphNode.adjacentVertices[bfsZeroInDegreeQueue.poll()]){
               inDegreeArr[adjacentVertex]--;
               if(inDegreeArr[adjacentVertex] == 0)
                   bfsZeroInDegreeQueue.offer(adjacentVertex);
           }
       }
       return topologicalVertexCount != graphNode.vertexes;
    }

    public static void main(String[] args) {
        CycleInDirectedGraphBFS obj = new  CycleInDirectedGraphBFS();
        GraphNode graph1 = new GraphNode(6, true);
        graph1.addVertex(0, 1);
        graph1.addVertex(1, 2);
        graph1.addVertex(2, 3);
        graph1.addVertex(3, 4);
        graph1.addVertex(3, 5);
        //graph1.addVertex(4, 2);
        System.out.println(obj.isCycle(graph1));

        GraphNode graph = new GraphNode(6, true );
        graph.addVertex(2, 3);
        graph.addVertex(3, 1);
        graph.addVertex(4, 0);
        graph.addVertex(4, 1);
        graph.addVertex(5, 0);
        graph.addVertex(5, 2);
        System.out.println(obj.isCycle(graph));
    }
}
