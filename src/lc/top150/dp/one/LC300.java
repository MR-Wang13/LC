package lc.top150.dp.one;

import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 0;
        for (int i =1; i<n ;i++){
            for (int j = 0 ; j<i ; j++){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        LC300 lc = new LC300();
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lc.lengthOfLIS(nums));
    }
}
