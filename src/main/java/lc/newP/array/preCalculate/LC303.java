package lc.newP.array.preCalculate;

public class LC303 {
    int[] preSum ;
    public LC303(int[] nums) {
        preSum = new int[nums.length+1];
        for (int i = 0 ; i<nums.length ; i++){
                preSum[i+1] = preSum[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
       return preSum[right+1] - preSum[left];
    }

    public static void main(String[] args) {
        int[] nums= {1,2,3,4,5,6};
        LC303 lc = new LC303(nums);
        System.out.println(lc.sumRange(0,5));
    }
}
