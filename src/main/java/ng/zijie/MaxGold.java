package ng.zijie;

import java.util.Arrays;

public class MaxGold {

    public static int maxGold(int n, int m, int[][] events) {
        // i j表示第i次事件 拥有j个宝石的情况下的最大金币数
        int[][] dp = new int[n + 1][m + 1];

        Arrays.fill(dp[0],-1);
        dp[0][0] = 0;

        for (int i = 1 ; i <= events.length;i++){
            int[] event = events[i-1];
            int x = event[0],y = event[1],z=event[2];
            for (int j = 0; j<=m;j++){
                //用x换y i-1 j-x状态转移到i j
                if (j>=x && dp[i - 1][Math.min(j - x,m)]!=-1){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][Math.min(j - x,m)] + y);
                }
                if (dp[i - 1][j] != -1) {
                    dp[i][Math.min(j + z, m)] = Math.max(dp[i - 1][j], dp[i][Math.min(j + z, m)]);
                }
            }
        }
        int maxGold = 0;
        for (int j = 0; j <= m; j++) {
            if (dp[n][j] != Integer.MIN_VALUE) {
                maxGold = Math.max(maxGold, dp[n][j] + j);
            }
        }
        return maxGold;
    }
    public static int maxGoldAI(int n, int m, int[][] events) {
        int[][] dp = new int[n + 1][m + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0; // Starting condition: 0 gold, 0 gems

        for (int i = 1; i <= n; i++) {
            int x = events[i - 1][0];
            int y = events[i - 1][1];
            int z = events[i - 1][2];

            for (int j = 0; j <= m; j++) {
                // Option 1: Spend x gems to get y gold (if possible)
                if (j >= x && dp[i - 1][j - x] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x] + y);
                }

                // Option 2: Get z gems (without exceeding the limit m)
                if (dp[i - 1][j] != Integer.MIN_VALUE) {
                    int newGemCount = Math.min(j + z, m);
                    dp[i][newGemCount] = Math.max(dp[i][newGemCount], dp[i - 1][j]);
                }
            }
        }

        // Find the maximum gold possible after processing all events
        int maxGold = 0;
        for (int j = 0; j <= m; j++) {
            if (dp[n][j] != Integer.MIN_VALUE) {
                maxGold = Math.max(maxGold, dp[n][j] + j);
            }
        }

        return maxGold;
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 5;
        int[][] events = {
                {2, 100, 5}, // Event 1: spend 2 gems, gain 100 gold, or gain 5 gems
                {3, 50, 2},  // Event 2: spend 3 gems, gain 50 gold, or gain 2 gems
                {5, 200, 10} // Event 3: spend 5 gems, gain 200 gold, or gain 10 gems
        };

        //System.out.println(maxGoldAI(n, m, events)); // 输出最大金币数
        System.out.println(maxGold(n, m, events)); // 输出最大金币数

    }
}
