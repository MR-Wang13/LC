package lc.ArrayTest;

public class SquaresSortedArray {
    /***
     *
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     */
    public int[] sortedSquares(int[] nums) {
        int start = 0 ,end = nums.length-1;
        int[] result = new int[nums.length];
        int index = nums.length-1;
        while(index>=0){
            if (Math.abs(nums[start])>Math.abs(nums[end])){
                result[index--] = nums[start]*nums[start];
                start++;
            }else {
                result[index--] = nums[end]*nums[end];
                end--;
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        SquaresSortedArray array = new SquaresSortedArray();
        array.sortedSquares(nums);
    }
}
