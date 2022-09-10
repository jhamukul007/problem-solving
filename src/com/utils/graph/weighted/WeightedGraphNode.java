package com.utils.graph.weighted;

import com.utils.pairs.Pair;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraphNode {

    public List<Pair<Integer,Integer>>[] adjacencyList;
    public int vertexes;

    public WeightedGraphNode(int vertexes, boolean zeroIndexed){
        this.vertexes = vertexes;
        adjacencyList = new List[vertexes];
        vertexes = zeroIndexed ? vertexes: vertexes+1;
        int i = zeroIndexed ? 0: 1;
        for(; i < vertexes; i++){
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdgeWithWeight(int from, int to, int weight){
        Pair<Integer,Integer> pair = new Pair<>(to, weight);
        adjacencyList[from].add(pair);
    }

}