package ng.meta;

import ng.shoppe.Solution;

public class MaxNonAdjacent {
    public static int maxNonAdjacentSum(int[] nums) {
        int n = nums.length;

        // 初始化第一大值和第二大值及其索引
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int index1 = -1 ,index2 = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > max1) {
                // 更新 max1
                if (Math.abs(i - index1) > 1) {
                    // 更新 max2，因为 max1 和它不相邻
                    max2 = max1;
                    index2 = index1;
                }
                max1 = nums[i];
                index1 = i;
            } else if (nums[i] > max2 && Math.abs(i - index1) > 1) {
                // 更新 max2，如果当前值比 max2 更大，且与 max1 不相邻
                max2 = nums[i];
                index2 = i;
            }
        }

        // 如果找到了两个非相邻元素，返回它们的和；否则返回 0
        return max1 != Integer.MIN_VALUE && max2 != Integer.MIN_VALUE ? max1 + max2 : 0;

    }
    public static int maxNonAdjacentSum1(int[] nums) {
        int n = nums.length;
        int max1 = 0, max2 = 0;
        int index1 = -1;
        // max1 > max2
        for(int i = 0; i < n; i++){
            if(nums[i] > max1){
                if( i - index1 > 1){
                    max2 = max1;
                }
                max1 = nums[i];
                index1 = i;

            }else if (nums[i] > max2 && i - index1 > 1){
                max2 = nums[i];
            }
        }
        return max1+max2;
    }
    public static void main(String[] args) {

        int[] nums1 = {3, 2, 1, 1};
        System.out.println(maxNonAdjacentSum1(nums1)); // 输出: 13

        int[] nums2 = {5, 1, 1, 5};
        System.out.println(maxNonAdjacentSum1(nums2)); // 输出: 10

        int[] nums3 = {8, 1, 4,10, 2};
        System.out.println(maxNonAdjacentSum1(nums3)); // 输出: 10
    }
}
