package ng.tiktok;

import java.util.Arrays;

public class DP {
    public static int climbStairs(int n) {
        if(n<=1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n ; i++ ){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2 ; i < n; i++){
           dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[n],dp[n-1]);
    }
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums,1,nums.length)),
                helper(Arrays.copyOfRange(nums,0,nums.length-1)));
    }
    public static int helper(int[] nums){
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-2],nums[n-1]);
        for(int i = n-3; i >= 0 ; i--){
            dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return Math.max(dp[0],dp[1]);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        if(s == null || s.length()==0){
            return "";
        }
        boolean[][] dp = new boolean[n][n];

        int maxI = 0;
        int maxJ = 0;
        for(int i = n-1; i >=0; i--){
            for(int j = i; j<n; j++){
                if(i == j){
                    dp[i][i] = true;
                }else if(i+1 ==j){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        if(j-i>maxJ-maxI){
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }else {
                    int left = i+1;
                    int right = j-1;

                    if(s.charAt(i) == s.charAt(j) && dp[left][right]){
                        dp[i][j] = true;
                        if(j-i>maxJ-maxI){
                            maxI = i;
                            maxJ = j;
                        }
                    }

                }

            }
        }
        return s.substring(maxI,maxJ+1);
    }
    /*
    * A string consisting of uppercase english characters can be encoded to a number using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode a message, digits must be grouped and then mapped back into letters using the reverse of the mapping above. There may be multiple ways to decode a message. For example, "1012" can be mapped into:

"JAB" with the grouping (10 1 2)
"JL" with the grouping (10 12)
    * */
    public static int numDecodings(String s) {
        /*int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return dfsNumDecodings(s,0,memo);*/
        int n = s.length();
        // how many ways from i to n;
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i  = n-1; i >= 0; i--){
            if(s.charAt(i) == 0){
                dp[i] = 0;
            }else {
                int way1 = dp[i+1];
                int way2 = 0;
                if(i+1 < n && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                    way2 = dp[i+2];
                }
                dp[i] = way2+way1;
            }
        }
        return dp[0];
    }

    private static int dfsNumDecodings(String s, int index, int[] memo) {
        if(index == s.length()){
            return 1;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int res = 0;
        for(int i = index; i < index+2 && i<s.length(); i++){
            if(s.charAt(index) == '0'){
                return 0;
            }
            String sub = s.substring(index,i+1);
            Integer subNum = Integer.valueOf(sub);
            if(subNum >= 1 && subNum <= 26){
                res+= dfsNumDecodings(s,i+1, memo);
            }
        }
        if(memo[index]!=-1){
            memo[index]+=res;
        }else {
            memo[index] = res;
        }
        return res;
    }

    public static void main(String[] args) {
       //System.out.println(longestPalindrome("abbc"));
        System.out.println(numDecodings("12"));
    }
}
