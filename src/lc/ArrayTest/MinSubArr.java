package lc.ArrayTest;

public class MinSubArr {

    // 暴力解法
    public int minSubArrayLen1(int s, int[] nums) {
        int length = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum =0;
           for (int j = i;j<nums.length;j++){
               sum +=nums[j];
               if (sum>=s){
                   result = (j-i+1)<result?(j-i+1):result;
                   break;
               }else {
                   sum+=nums[j];
               }
           }

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    // 滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) { //循环减去头部元素 直到小于s
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        MinSubArr subArr = new MinSubArr();
        subArr.minSubArrayLen1(s,nums);
    }
}
