package com.string;

import com.utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KFreuestWord {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> coutMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            coutMap.put(words[i], coutMap.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> coutMap.get(a) == coutMap.get(b) ? b.compareTo(a) :
                coutMap.get(a) - coutMap.get(b));

        for (String s : coutMap.keySet()) {
            minHeap.add(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(minHeap.poll());
            k--;
        }
        Collections.reverse(result);
        return result;
    }


    public static void main(String[] args) {
        KFreuestWord obj = new KFreuestWord();
        System.out.println(obj.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
