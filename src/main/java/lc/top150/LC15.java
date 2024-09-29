package lc.top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=0;i<n;i++){
            if (nums[i]>0){
                continue;
            }
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1,right = n-1,target = -nums[i];

            while (left<right){

                if (nums[left]+nums[right]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++; right--;
                    while (left<right&&nums[right+1]==nums[right]){
                        right--;
                    }
                    while (left<right&&nums[left-1]==nums[left]){
                        left++;
                    }
                }else if (nums[left]+nums[right]>target){
                    right--;
                }else {
                    left++;
                }

            }
        }
        return result;
    }
    public static void main(String[] args) {
        LC15 lc = new LC15();
        int[] nums = {1,2,-2,-1};
        System.out.println(lc.threeSum(nums));
    }
}
