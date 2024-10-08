package ng.tiktok.vo;

import java.util.Arrays;
import java.util.HashSet;

public class LC128 {
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1,count = 1;
        for (int i =0 ; i<nums.length-1;i++){

            if(nums[i] == nums[i+1]-1){
                count++;
                max= Math.max(max,count);
            }else if(nums[i] == nums[i+1]){
                continue;
            }else  {
                max= Math.max(max,count);
                count=1;
            }
        }
        return  max;


    }
    public static int longestConsecutiveOp(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int longestStreak = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return  longestStreak;


    }
    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
