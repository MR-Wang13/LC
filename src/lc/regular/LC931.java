package lc.regular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC931 {

    static int min = 100000 ;
    static int sum = 0;
    /**
     * 回溯容易超时
    static public int minFallingPathSum(int[][] matrix) {
        min = 100000;

        for (int i = 0 ;i<matrix.length; i++){
            sum+=matrix[0][i];
            backTracking(1,matrix,i);
            sum-=matrix[0][i];
        }
        return min;
    }

     *
     * */
    private static void backTracking(int row, int[][] matrix,int col) {
        if (row==matrix.length){
            min = Math.min(min,sum);
            return;
        }
        int i = col-1;
        while (i<=col+1){
            if (i>=0 && i<matrix.length){
                sum+= matrix[row][i];
                backTracking(row+1,matrix,i);
                sum-= matrix[row][i];
            }
            i++;

        }
    }

    /**
     * dp dynamic programming
     * 倒着来 当前加上上一列可能的值
     *
    static public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int j = 0; j<m; j++){
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1 ; i<n ; i++){
            for (int j = 0; j<m ; j++){
                int ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
                int up = matrix[i][j] + dp[i-1][j];

                if (j-1 >=0){
                    ld = matrix[i][j] + dp[i-1][j-1];
                }

                if (j+1 >=0){
                    rd = matrix[i][j] + dp[i-1][j+1];
                }
                dp[i][j] = Math.min(up,Math.min(ld,rd));
            }
        }
        int min = dp[n-1][0];
        for (int j=1; j<m; j++){
            min = Math.min(min,dp[n-1][j]);
        }
        return min;
    }
     */

    /**
     * dp dynamic programming
     * 正着来 递归
     *
     * */
     static public int minFallingPathSum(int[][] matrix) {
         int n = matrix.length;
         int m = matrix[0].length;
         if (m==1 || n==1) return matrix[0][0];
         int[][] dp = new int[n][m];

         for (int[] row :  dp){
             Arrays.fill(row,Integer.MAX_VALUE);
         }
         int min = Integer.MAX_VALUE;
         for (int i = 0; i<matrix.length; i++){
             min = Math.min(min,minFallingPathSum(matrix,0,i,dp));
         }

         return min;
     }

    private static int minFallingPathSum(int[][] matrix, int row, int col, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }

        if (row == m-1){
            return dp[row][col] = matrix[row][col];
        }

        int left = Integer.MAX_VALUE,right = Integer.MAX_VALUE;

        if (col>0){
            left = minFallingPathSum(matrix,row+1,col-1,dp);
        }

        int straight = minFallingPathSum(matrix,row+1,col,dp);

        if (col < n-1){
            right = minFallingPathSum(matrix,row+1,col+1,dp);
        }

        dp[row][col] = Math.min(left,Math.min(straight,right))+matrix[row][col];

        return dp[row][col];
    }

    public static void main(String[] args) {
       int[][] matrix = {{-19,57},{-40,-5}};
        System.out.println(minFallingPathSum(matrix));
    }
}
