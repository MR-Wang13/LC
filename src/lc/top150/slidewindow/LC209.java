package lc.top150.slidewindow;

public class LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left= 0 ,right = 0,n = nums.length;
        int minLength=100001;
        int sum = nums[0];
        while (left<=right){
            if (sum>=target){
                minLength= Math.min(minLength,right-left+1);
                sum -=nums[left];

                left++;

            }else {
                right++;
                if (right>=n){
                    break;
                }
                sum+=nums[right];
            }
        }
        return minLength==100001?0:minLength;
    }

    public static void main(String[] args) {
        LC209 lc = new LC209();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(lc.minSubArrayLen(target,nums));
    }
}
