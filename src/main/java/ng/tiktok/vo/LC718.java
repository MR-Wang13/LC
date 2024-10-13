package ng.tiktok.vo;

public class LC718 {
    public static int findLengthDP(int[] nums1, int[] nums2) {
        // dp[i][j] represents for the most common prefix length of nums1[0..i-1]
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int maxLength = 0;
        for (int i = 1;i<=m ; i++){
            for (int j = 1;j<=n ; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = 0;
                }
                maxLength = Math.max(maxLength,dp[i][j]);
            }
        }
        return maxLength;

    }



    public static void main(String[] args) {
      int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
      findLengthDP(nums1,nums2);

    }
}
