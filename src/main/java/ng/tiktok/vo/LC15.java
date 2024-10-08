package ng.tiktok.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i<n ; i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }

            int target = -nums[i],left = i+1,right=n-1;
            while (left < right && right > i){

                if(nums[left]+nums[right]==target && left<right){
                    List<Integer> temp =  new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right] );
                    result.add(temp);
                    while (left < right-1 &&right>i &&nums[right]==nums[right-1]){
                        right--;
                    }
                    while (left < right &&left+1<n&&nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;right--;
                }
                while (left < right && right > i && nums[left] + nums[right] > target){
                    right--;
                }
                while (left < right && right > i && nums[left] + nums[right] < target){
                    left++;
                }


            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        threeSum(nums);
    }
}
