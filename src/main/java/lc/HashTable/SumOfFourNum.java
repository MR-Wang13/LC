package lc.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfFourNum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i<nums.length; i++){
            //
            if (nums[i]>target){
                return result;
            }
            //
            if (i>0&& nums[i-1]==nums[i]){
                continue;
            }
            for (int j = i+1 ; j<nums.length; j++){
                if (j>i+1&& nums[j-1]==nums[j]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left<right){
                    if (target-nums[i]-nums[j]-nums[left]-nums[right]>0){
                        left++;
                    }else if (target-nums[i]-nums[j]-nums[left]-nums[right]<0){
                        right--;
                    }else {
                        result.add(Arrays.asList(nums[left],nums[right],nums[i],nums[j]));
                        while (left<right && nums[left]==nums[left+1]) left++;
                        while (left<right && nums[right]==nums[right-1]) right--;

                        left++;
                        right--;
                    }
                }
            }

        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        SumOfFourNum sumOfFourNum = new SumOfFourNum();
        List<List<Integer>> result = sumOfFourNum.fourSum(nums,target);
        System.out.println(result);

    }
}
