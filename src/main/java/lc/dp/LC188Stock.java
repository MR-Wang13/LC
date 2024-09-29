package lc.dp;

public class LC188Stock {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][k+1][2];
        dp[0][k][0] = 0;
        dp[0][k-1][1] = -prices[0];
        for (int i = 1 ; i<prices.length;i++){
            if (k>0){
                dp[i][k][0] = Math.max(dp[i-1][k][0],prices[i]+dp[i-1][k][1]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[prices.length][k][0];
    }
}
