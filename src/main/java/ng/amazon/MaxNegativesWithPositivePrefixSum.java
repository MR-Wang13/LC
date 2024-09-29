package ng.amazon;
import java.util.PriorityQueue;
import java.util.PriorityQueue;

public class MaxNegativesWithPositivePrefixSum {
    public static int maxNegatives(int[] nums) {
        int left  =0 ,n = nums.length,right = n-1;
        int sum = 0;
        while (left<=right){
            if (sum-nums[right]>0){
                sum -=nums[right];
                right--;
            }else {
                sum+=nums[left];
                left++;
            }

        }

        return n-1-right;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 1, 1};
        System.out.println(maxNegatives(nums));  // 输出 3
    }
}
