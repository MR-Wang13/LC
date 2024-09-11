package lc.top150;

import java.util.HashSet;

public class Review {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;

        int left =0,right = n-1;
        while (left<=right){
            while (left<n&&nums[left]!=val){
                left++;
            }
            while (right>=0 && nums[right]==val){
                right--;
            }
            if(left<=right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        return left;
    }

    public int removeDuplicates(int[] nums) {

        int k =0,n = nums.length;
        if (n == 0) {
            return 0;
        }
        for (int i = 1 ; i<n;i++){
            if (nums[i]!=nums[k]){
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }

    public int removeDuplicates2(int[] nums) {
        int k =2,n = nums.length;
        if (n <=2) {
            return n;
        }
        for (int i = 2 ; i<n;i++){
            if (nums[i]!=nums[k-1] ||nums[i]!= nums[k-2]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public void rotate(int[] nums, int k) {
         k =  k%nums.length;
         reverse(0,nums.length-1,nums);
         reverse(0,k-1,nums);
         reverse(k,nums.length-1,nums);

        System.out.println(nums);
    }

    private void reverse(int left, int right, int[] nums) {
        while (left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;right--;
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left = 0;
        int max = 0;
        for (int i =1 ; i<n ; i++){
            if (prices[i]<prices[left]){
                left = i;
            }else {
                max = Math.max(max,prices[i]-prices[left]);
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int left = 0;
        int max = 0;
        for (int i =1 ; i<n ; i++){
            if (prices[i]<prices[left]){
                left = i;
            }else {
                max +=(prices[i]-prices[left]);
                left = i;
            }
        }
        return max;
    }

    public int maxProfit2dp(int[] prices) {

        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i =1 ; i<n ; i++){
            dp[i] = Math.max(dp[i-1],dp[i-1]+(prices[i]-prices[i-1]));
        }
        return dp[n-1];
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int bound = 0;
        for (int i =0 ; i<=bound ; i++){
            bound = Math.max(bound,i+nums[i]);
            if (bound>=n-1){
                return true;
            }
        }
        return false;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int bound = 0;
        int cur = 0;
        for (int i = 0 ; i<n-1;i++){
            bound = Math.max(bound,i+nums[i]);
            if (i == cur){
                steps++;
                cur = bound;
            }
        }
        return steps;
    }
    public static void main(String[] args) {
        Review review = new Review();
        int[] nums = {2,3,0,1,4};
        ;
        System.out.println(review.jump(nums));
    }
}
