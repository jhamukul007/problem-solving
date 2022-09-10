package com.dp;

import com.utils.Utils;

public class FabbianoSeries {
    /**
     * Tabulation
     * Space: O(n)
     * Time: O(n)
     * @param n
     * @return
     */
    public int nfabbianoSeries(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        Utils.print(dp);
        return dp[n-1];
    }

    /**
     * Memorization
     * Space : O(n) + O(n) -> Stack space
     * Time : O(n)
     * @param n
     */

    public int fabbianicSeries(int n){
        if(n <= 2)
            return 1;
        int[] dp = new int[n+1];
        return nFabbianicSeries(n, dp);
    }

    public int nFabbianicSeries(int n, int[] dp){
        if(n <= 3)
            return 1;
        if(dp[n] != 0)
            return dp[n];
        return dp[n] = nFabbianicSeries(n-1, dp) + nFabbianicSeries(n-2, dp);
    }

    public int fabbianicSeriesOptimized(int n){
        int secLast = 0;
        int last = 1;
        for(int i = 3; i <= n; i++){
            int current = last + secLast;
            secLast = last;
            last = current;
        }
        return last;
    }

    public static void main(String[] args) {
        // 0, 1, 1, 2 , 3 , 5, 8 , 13
        FabbianoSeries obj = new FabbianoSeries();
        //Utils.print(obj.nfabbianoSeries(6));

        Utils.print(obj.fabbianicSeries(6));
        Utils.print(obj.fabbianicSeriesOptimized(4));
    }

}
