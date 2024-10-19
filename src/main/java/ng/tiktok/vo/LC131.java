package ng.tiktok.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC131 {
    public static List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(boolean[] d : dp){
            Arrays.fill(d,false);
        }
        for(int i= 0;i<n; i++) {
            dp[i][i] = true ;
        }
        for(int i= 0;i<n-1; i++) {
            dp[i][i+1] = s.charAt(i) ==s.charAt(i+1);
        }
        for(int i= n-1;i>=0; i--){
            for(int j = i+1; j<n ;j++){
                if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        dp(0,dp,result,new ArrayList<String>(),s);
        return result;
    }

    private static void dp(int n, boolean[][] dp, List<List<String>> result, ArrayList<String> strings,String s ){
        if(n == s.length()){
            result.add(new ArrayList<>(strings));
            return;
        }
        for(int i = n ; i<s.length();i++){
            if(dp[n][i]){
                strings.add(s.substring(n,i+1));
                dp(i+1,dp,result,strings,s);
                strings.remove(strings.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        partition("aab");
    }
}
