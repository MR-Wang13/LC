package lc.top150.dp.multip;

public class LC10 {
    public boolean isMatch(String s, String p) {
        int m =s.length(),n = p.length();
        boolean[][] dp  = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0 ; i<=m ; i++)
            for (int j = 1 ; j<=n;j++){
                if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];//当*为0时 状态转移到去掉两个字符到状态
                    if (match(s,p,i,j-1)){//和上个字符匹配
                        dp[i][j] = dp[i][j] || //任选一种情况
                                dp[i-1][j]; //匹配多次
                    }
                }else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i-1][j-1];//如果匹配延续状态
                    }
                }
            }
        return dp[m][n];

    }

    private boolean match(String s, String p, int i, int j) {
        if (p.charAt(j-1)=='.'){
            return true;
        }
        if (i==0){
            return false;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }

    public static void main(String[] args) {
        LC10 lc = new LC10();
        lc.isMatch("abbbbc","ab*d*c");
    }
}
