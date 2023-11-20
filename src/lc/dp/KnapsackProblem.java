package lc.dp;

public class KnapsackProblem {

    int Knapsack2d(int[] w,int v[],int capacity){
        int n = w.length;
        int[][] dp = new int[n+1][capacity+1];
        for (int i=1; i<=n; i++){
            for (int j = 1; j<=capacity; j++ ){
                if (w[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],v[i-1]+dp[i-1][j-w[i-1]]);
                }
            }
        }
        return dp[n][capacity];
    }
    int Knapsack1d(int[] w,int v[],int capacity){
        int n = w.length;
        int[] dp = new int[capacity+1];
        for (int i =1; i<=n; i++)
            for (int j = capacity; j>=w[i-1]; j-- ){
                dp[j] = Math.max(dp[j],dp[j-w[i-1]]+v[i-1]);
            }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] w ={3,1,3,4,2};
        int[] v = {2,2,4,5,3};
        int capacity = 7;
        KnapsackProblem problem = new KnapsackProblem();
        System.out.println(problem.Knapsack2d(w,v,capacity));
        System.out.println(problem.Knapsack1d(w,v,capacity));
    }
}
