package com.graph;

import com.utils.Utils;

import java.util.List;

public class BipartiteGraphDFS {

    public static boolean isBipartite(GraphNode graphNode) {
        List<Integer>[] adjacencyList = graphNode.adjacentVertices;
        // using two color 1 and 2
        int[] coloredWith = new int[graphNode.vertexes + 1];
        for (int vertex = 1; vertex <= graphNode.vertexes; vertex++) {
            if (coloredWith[vertex] == 0) {
                if (!isBipartite(vertex, 0, adjacencyList, coloredWith))
                    return false;
            }
        }
        return true;
    }

    static boolean isBipartite(int vertex, int prevVertex, List<Integer>[] adjacencyList, int[] coloredWith) {
        //coloredWith[vertex] = invertColor(coloredWith[prevVertex]);
        if(coloredWith[prevVertex] == 0)
            coloredWith[vertex] = 1;
        for (int nextVertex : adjacencyList[vertex]) {
            if (coloredWith[nextVertex] == 0){
                coloredWith[nextVertex] = invertColor(coloredWith[vertex]);
                isBipartite(nextVertex, vertex, adjacencyList, coloredWith);
            }
            else if (coloredWith[nextVertex] == coloredWith[vertex])
                return false;
        }
        return true;
    }

    static int invertColor(int color) {
        return color == 2 ? color - 1 : color + 1;
    }

    public boolean isBipartite(int[][] matrix) {
        // using two color 1 and 2
        int[] coloredWith = new int[matrix.length];
        for (int vertex = 0; vertex < coloredWith.length; vertex++) {
            if (coloredWith[vertex] == 0) {
                if (!isBipartite(vertex, 0, matrix, coloredWith))
                    return false;
            }
        }
        return true;
    }

    boolean isBipartite(int vertex, int prevVertex, int[][] matrix, int[] coloredWith) {
        if(coloredWith[prevVertex] == 0)
            coloredWith[vertex] = 1;
        for (int nextVertex : matrix[vertex]) {
            if (coloredWith[nextVertex] == 0)
                if(!isBipartite(nextVertex, vertex, matrix, coloredWith))
                    return false;
            else if (coloredWith[nextVertex] == coloredWith[vertex])
                return false;
        }
        return true;
    }



    public static void main(String[] args) {
//        GraphNode graph3 = new GraphNode(4);
//        graph3.addVertex(1, 2);
//        graph3.addVertex(1, 4);
//        graph3.addVertex(2, 1);
//        graph3.addVertex(2, 3);
//        graph3.addVertex(3, 2);
//        graph3.addVertex(3, 4);
//        graph3.addVertex(4, 1);
//        graph3.addVertex(4, 3);
//        Utils.print(graph3.adjacentVertices);
//        System.out.println(isBipartite(graph3));

        //int[][]  matrix = {{1,2,3},{0,2},{0,1,3},{0,2}};
        //int[][] matrix = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9}, {1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};\
        //int[][] matrix = {{1,3},{0,2},{1,3},{0,2}};
        int[][] matrix = {{1},{0,2},{1,3,4},{2},{2}};
        BipartiteGraphDFS dfsTraversal = new BipartiteGraphDFS();
        System.out.println(dfsTraversal.isBipartite(matrix));
    }
}
