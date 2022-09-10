package com.array;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 56. Merge Intervals
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        List<int[][]> result = new ArrayList<>();
        Arrays.sort(intervals , Comparator.comparingInt(b -> b[0]));

        int minStarting = intervals[0][0];
        int maxEnding = intervals[0][1];

        for(int i = 0; i < intervals.length; i++){

            if(i < intervals.length- 1 && intervals[i][1] >= intervals[i+1][0]){
                //overlap interval
                minStarting = Math.min(minStarting, Math.min(intervals[i][0], intervals[i+1][0]));
                maxEnding = Math.max(maxEnding, Math.max(intervals[i][1], intervals[i+1][1]));
            }
            else{
                if(minStarting != Integer.MAX_VALUE  && maxEnding != Integer.MIN_VALUE){
                    int[][] data = new int[1][2];
                    data[0][0] = minStarting;
                    data[0][1] = maxEnding;
                    result.add(data);
                    minStarting = Integer.MAX_VALUE;
                    maxEnding =  Integer.MIN_VALUE;
                }
                else{
                    int[][] data = new int[1][2];
                    data[0][0] = intervals[i][0];
                    data[0][1] = intervals[i][1];
                    result.add(data);
                }
            }
        }
        int[][] resultMatrix = new int[result.size()][2];
        int index = 0;
        for(int[][] data : result){
            resultMatrix[index][0] = data[0][0];
            resultMatrix[index++][1] = data[0][1];
        }
        return resultMatrix;
    }

        public static void main(String[] args) {
            MergeIntervals obj = new MergeIntervals();
            //int[][] intervals = {{1,4}, {4,5}};
            //int[][] intervals = {{1,3}, {2,6},{8,10},{15,18}};
            int[][] intervals = {{2,3}, {4,5},{6,7}, {8,9},{1,10}};
            Utils.print(obj.merge(intervals));
        }

    // sorted by startTime : {1,10}

    //{{1,10},{2,3}, {4,5},{6,7}, {8,9}}
    //
}
