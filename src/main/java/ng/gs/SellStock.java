package ng.gs;

public class SellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        while(right < prices.length){
            int profit = prices[right] - prices[left];
            if(profit > 0){
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            }else{
                left = right;
                right++;
            }
        }

        return maxProfit;

    }
}
