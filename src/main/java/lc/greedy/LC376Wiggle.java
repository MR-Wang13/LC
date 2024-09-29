package lc.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LC376Wiggle {
    static public int wiggleMaxLength(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int start = 0;
        int count=1;
        while (start<nums.length-1 && nums[start]==nums[start+1]){
            start++;
        }
        if (start==nums.length-1){
            return count;
        }
        boolean flag = nums[start]>nums[start+1];
        count++;
        for (int i = start+1 ; i<nums.length-1; i++){
            if (nums[i]!=nums[i+1] && !flag == nums[i]>nums[i+1]){
                flag=!flag;
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(wiggleMaxLength(nums));
    }
}
