package lc.greedy;

public class LC53MaxSub {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0 ; i<nums.length; i++){
            count+=nums[i];
            max = Math.max(max,count);
            if (count<=0){
                count=0;
            }
        }
        return max;
    }
    /***
     * dp
     *
     *
     * */
    public int maxSubArrayDP(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        max = dp[0];
        for (int i = 1 ; i<nums.length; i++){
           dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
           max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        LC53MaxSub lc53MaxSub  = new LC53MaxSub();
        System.out.println(lc53MaxSub.maxSubArrayDP(nums));
    }
}
