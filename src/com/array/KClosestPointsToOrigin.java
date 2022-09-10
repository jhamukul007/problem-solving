package com.array;

import com.utils.Utils;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    /**
     * Space : O(n)
     * Time : nlog(k)
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Data> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b.distance, a.distance));

        Data data;
        for (int i = 0; i < k; i++) {
            data = new Data(points[i][0], points[i][1]);
            maxHeap.add(data);
        }

        for (int i = k; i < points.length; i++) {
            double dis = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            if (dis <= maxHeap.peek().distance) {
                maxHeap.poll();
                maxHeap.add(new Data(points[i][0], points[i][1]));
            }
        }

        int[][] result = new int[k][2];
        int index = 0;

        while (!maxHeap.isEmpty()) {
            result[index][0] = maxHeap.peek().x;
            result[index++][1] = maxHeap.peek().y;
            maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        //int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        //int[][] points = new int[][]{{1,3},{-2,2}};
        //KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        //Utils.print(obj.kClosest(points, 1));
        int n = 20;
        System.out.println((n&1)!= 1);
    }
}

class Data {

    public int x;
    public int y;
    public double distance;

    public double distance(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = distance(x, y);
    }

}
