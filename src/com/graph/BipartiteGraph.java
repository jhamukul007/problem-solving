package com.graph;

import com.utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {

    public static boolean isBipartite(GraphNode node) {
        // First color is 1 and second color is 2
        int[] coloredWith = new int[node.vertexes + 1];
        for(int i = 1; i <= node.vertexes; i++){
            if(coloredWith[i] == 0) {
                if (!canUseTwoColor(1, node.adjacentVertices, coloredWith))
                    return false;
            }
        }
        return true;
    }

    static boolean canUseTwoColor(int currentVertex, List<Integer>[] adjacentVertices, int[] coloredWith) {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(currentVertex);
        coloredWith[currentVertex] = 1;
        while (!bfs.isEmpty()) {
            currentVertex = bfs.poll();

            for (int adjacentVertex : adjacentVertices[currentVertex]) {
                if (coloredWith[adjacentVertex] == 0) {
                    coloredWith[adjacentVertex] = getOppositeColor(coloredWith[currentVertex]);
                    bfs.add(adjacentVertex);
                } else if (coloredWith[currentVertex] == coloredWith[adjacentVertex])
                    return false;
            }
        }
        System.out.println("------------- Colored with");
        Utils.print(coloredWith);
        return true;
    }

    static int getOppositeColor(int color) {
        return color != 1 ? color - 1 : color + 1;
    }

    /**
     *
     * @param
     */

    public boolean isBipartite(int[][] graph) {
        int[] colored = new int[graph.length];
        for(int i = 0 ; i < graph.length; i++ ){
            if(colored[i] == 0){
                if(!isBipartite(i, graph, colored))
                    return false;
            }
        }
        return true;
    }

    boolean isBipartite(int currentVertex, int[][] graph, int[] colored){
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(currentVertex);
        colored[currentVertex] = 1;

        while(!bfs.isEmpty()){
            currentVertex = bfs.poll();
            for(int nextAdjacentVertex : graph[currentVertex]){
                if(colored[nextAdjacentVertex] == 0){
                    colored[nextAdjacentVertex] = getOppositeColor(colored[currentVertex]);
                    bfs.add(nextAdjacentVertex);
                }
                else if(colored[nextAdjacentVertex] == colored[currentVertex]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        GraphNode graph = new GraphNode(4);
//        graph.addVertex(1, 2);
//        graph.addVertex(2, 1);
//        graph.addVertex(2, 3);
//        graph.addVertex(2, 4);
//        graph.addVertex(3, 2);
//        graph.addVertex(4, 2);
//        Utils.print(graph.adjacentVertices);
//        System.out.println(isBipartite(graph));
//
//        System.out.println("-------------------------");
//
//        GraphNode graph1 = new GraphNode(6);
//        graph1.addVertex(1, 2);
//        graph1.addVertex(1, 3);
//        graph1.addVertex(2, 1);
//        graph1.addVertex(2, 4);
//        graph1.addVertex(2, 5);
//        graph1.addVertex(3, 1);
//        graph1.addVertex(3, 5);
//        graph1.addVertex(4, 2);
//        graph1.addVertex(4, 5);
//        graph1.addVertex(4, 6);
//        graph1.addVertex(5, 2);
//        graph1.addVertex(5, 3);
//        graph1.addVertex(5, 4);
//        graph1.addVertex(5, 6);
//        graph1.addVertex(6, 4);
//        graph1.addVertex(6, 5);
//        Utils.print(graph1.adjacentVertices);
//        System.out.println(isBipartite(graph1));
//
//
//        GraphNode graph2 = new GraphNode(6);
//        graph2.addVertex(1, 2);
//        graph2.addVertex(1, 3);
//        graph2.addVertex(2, 1);
//        graph2.addVertex(2, 4);
//        graph2.addVertex(2, 5);
//        graph2.addVertex(3, 1);
//        graph2.addVertex(3, 5);
//        graph2.addVertex(4, 2);
//        //graph2.addVertex(4, 5);
//        graph2.addVertex(4, 6);
//        graph2.addVertex(5, 2);
//        graph2.addVertex(5, 3);
//        //graph2.addVertex(5, 4);
//        graph2.addVertex(5, 6);
//        graph2.addVertex(6, 4);
//        graph2.addVertex(6, 5);
//        Utils.print(graph2.adjacentVertices);
//        System.out.println(isBipartite(graph2));


        GraphNode graph3 = new GraphNode(4);
        graph3.addVertex(1, 2);
        graph3.addVertex(1, 4);
        graph3.addVertex(2, 1);
        graph3.addVertex(2, 3);
        graph3.addVertex(3, 2);
        graph3.addVertex(3, 4);
        graph3.addVertex(4, 1);
        graph3.addVertex(4, 3);
        Utils.print(graph3.adjacentVertices);
        System.out.println(isBipartite(graph3));

        BipartiteGraph obj = new BipartiteGraph();
        int[][] edges = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(obj.isBipartite(edges));
    }

}
