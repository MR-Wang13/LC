package intern.snowflake;

public class StringPatterns {

    int calculate(int len,int maxV){
        int i, j;
        int MOD = 1000000007;
        int[][] dp = new int[len+1][maxV+1];

        int sum = 1;
        for (i = 1 ; i<=len;i++){
            for (j = 0 ; j<=maxV;j++){
                if (j==0){
                    //vowel的个数
                    dp[i][j] = sum * 21;
                    dp[i][j] %=MOD;
                    sum = dp[i][j];
                    continue;
                }
                if (j>i){
                    dp[i][j] = 0;
                }else if (j==i){
                    dp[i][j] = calPower(5,i,MOD);
                }else {
                    dp[i][j]=dp[i-1][j-1] * 5;
                }
                dp[i][j] %= MOD;

                sum+=dp[i][j];
                sum%=MOD;
            }
        }
        return sum;
    }

    private int calPower(int x, int y, int p)
    {
        int res = 1;

        while (y > 0)
        {
            res *= x;
            res %=p;
            y--;
        }
        return res;
    }
    int calculate1(int len,int maxV){
        int MOD =1000000007;
        int i ,j ;
        int[][] dp = new int[len+1][maxV+1];
        int sum=1;
        for ( i =1; i<=len ; i++){
            for (j =0; j<=maxV;j++){
                if (j==0){
                    dp[i][j]=sum*21;
                    dp[i][j]%=MOD;
                    sum = dp[i][j];
                    continue;
                }

                if (j>i){
                    dp[i][j] = 0;
                }else if (j==i){
                    dp[i][j] = calPower(5,i,MOD);
                }else {
                    dp[i][j]=dp[i-1][j-1] * 5;
                }
                dp[i][j]%=MOD;
                sum+=dp[i][j];
                sum%=MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        StringPatterns sp = new StringPatterns();
        System.out.println(sp.calculate1(4,1));

        System.out.println(sp.calPower(5,2,1000000007));
    }
}
