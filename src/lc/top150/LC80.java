package lc.top150;

import java.util.HashMap;

public class LC80 {
    public int removeDuplicates(int[] nums) {
        int k = 2;
        for (int i =2; i<nums.length; i++){
            if (nums[i]!=nums[k-2]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        LC80 lc = new LC80();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(lc.removeDuplicates(nums));
    }
}
