package ng.tiktok.vo;

public class LC64 {
    public int minPathSum(int[][] grid) {
        //只能向右下出发
        int m = grid.length, n = grid[0].length;
        //dp[i][j] 表示 到 位置i j 的最小路径
        //初始化 第一行 和 第一列 他们的最小值是固定的
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //第一行
        for (int i = 1 ; i<n ; i++){
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }
        //第一列
        for (int i = 1 ; i<m ; i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }

        for(int i =1 ; i<m ; i++){
            for (int j =1 ; j<n; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    public int minPathSumOP(int[][] grid) {
        //只能向右下出发
        int m = grid.length, n = grid[0].length;

        //第一行
        for (int i = 1 ; i<n ; i++){
            grid[0][i] = grid[0][i]+grid[0][i-1];
        }
        //第一列
        for (int i = 1 ; i<m ; i++){
            grid[i][0] = grid[i][0]+grid[i-1][0];
        }

        for(int i =1 ; i<m ; i++){
            for (int j =1 ; j<n; j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}
