package lc.top150.KadanesAlgorithm;

public class KadanesAlgorithm {
    public static int maxSubArray(int[] nums) {
        // 初始化最大子数组和为第一个元素
        int maxSubarray = nums[0];
        int currentSubarray = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前子数组和为负数，则从当前元素重新开始
            currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
            // 更新全局最大子数组和
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));  // 输出: 6
    }
}
