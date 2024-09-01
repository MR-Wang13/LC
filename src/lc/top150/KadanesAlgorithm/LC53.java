package lc.top150.KadanesAlgorithm;

public class LC53 {
    public int maxSubArray(int[] nums) {
        int count = 0,max = Integer.MIN_VALUE;
        for (int i = 0 ;i<nums.length;i++){
            count+=nums[i];
            max = Math.max(count,max);
            if (count<0){
                count=0;
            }
        }
        return max;
    }
    public int maxSubArrayDP(int[] nums) {
        int n  = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i  = 1; i<n ; i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        LC53 lc = new LC53();
        int[] nums = {-2, -1, -3, 4, -1, 2, 1, -5, -4};
        System.out.println(lc.maxSubArrayDP(nums));
    }
}
