package lc.top150.dp.one;

import lc.newP.doubleLinkList.LC19;

import java.util.HashSet;

public class LC198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i=2 ; i<n; i++){

            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);

        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        LC198 lc = new LC198();
        int[] nums = {2,7,9,3,1};
        System.out.println(lc.rob(nums));
    }
}
