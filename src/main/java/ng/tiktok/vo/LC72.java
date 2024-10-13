package ng.tiktok.vo;

import java.util.Arrays;

public class LC72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1;i<=m;i++){
            dp[i][0] = i;
        }

        for (int i = 1;i<=n;i++){
            dp[0][i] = i;
        }

        for(int i = 1; i<=m ; i++){
            for(int j = 1; j<=n ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }

        return dp[m][n];
    }

    public int minDistanceReverseWithMemo(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n];
        for(int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return dp(word1,m-1,word2,n-1,memo);
    }

    private int dp(String word1, int i, String word2, int j, int[][] memo) {
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if (memo[i][j] !=-1){
            return memo[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            memo[i][j] =  dp(word1,i-1,word2,j-1,memo);
        }else {
            memo[i][j] = Math.min(dp(word1,i-1,word2,j,memo)+1,Math.min(
                    dp(word1,i,word2,j-1,memo)+1,
                    dp(word1,i-1,word2,j-1,memo)+1
            ));
        }
        return memo[i][j];

    }
}
