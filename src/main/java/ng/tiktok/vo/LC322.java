package ng.tiktok.vo;

import java.util.Arrays;

public class LC322 {
    public static int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private static int coinChange(int[] coins, int amount, int[] memo) {
        if(amount<0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        if(memo[amount-1] != 0){
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int res = coinChange(coins, amount - coin, memo);
            if(res >=0 && res < min){
                min = 1 + res;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE)? -1 : min;
        return memo[amount -1];
    }

    public static void main(String[] args) {
        int[] coins ={186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(coins,amount));
    }
}
