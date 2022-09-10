package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphDFS {

    public List<Integer> graphDFS(GraphNode graph){
        //Total number of vertex in given graph
        int noOfVertex = graph.vertexes;

        Queue<Integer> graphVertex = new LinkedList<>();
        //Marking vertex as visited
        int[] visited = new int[noOfVertex];
        List<Integer> bfsResult = new ArrayList<>();
        for(int i = 1 ; i <= noOfVertex; i++){
           if(visited[i] == 0 ){
               graphVertex.offer(i);
               visited[i] = 1;
               while (!graphVertex.isEmpty()){
                   int vertex = graphVertex.poll();
                   bfsResult.add(vertex);
                  for(int j : graph.adjacentVertices[vertex]){
                      if(visited[j] == 0){
                          graphVertex.offer(j);
                          visited[j] = 1;
                      }
                  }
               }
           }
        }
        return bfsResult;
    }

    public static void main(String[] args) {
        GraphNode graph = new GraphNode(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        GraphDFS graphDFS = new GraphDFS();
        System.out.println(graphDFS.graphDFS(graph));
    }
}
