package lc.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0]>0){
            return result;
        }
        for (int i = 0; i<nums.length ; i++){
            int first = nums[i];
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = first + nums[left] + nums[right];
                if (sum>0){
                    right--;
                }else if (sum<0){
                    left++;
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums =  {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
}
