package lc.greedy;

public class LC122BestTimeSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i<prices.length-1 ; i++){
            maxProfit+=Math.max(0,prices[i+1]-prices[i]);
        }
        return maxProfit;
    }

    /**
    * dp
    * dp[i][0] 表示第i天 不持有/卖出当前的利润
    * dp[i][1] 表示第i天 持有/买入当前的利润
     *
     *
    * */
    public int maxProfitDP(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1 ; i<prices.length ; i++){
            //卖出  前一天卖出 和 今天卖出比较
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //买入 是前一天持有 和 还是今天持有 比较
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        //返回最后一天不持有的数据
        return dp[prices.length-1][0];
    }
    public static void main(String[] args) {
        LC122BestTimeSellStock lc = new LC122BestTimeSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(lc.maxProfitDP(prices));
    }
}
