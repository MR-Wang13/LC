package lc.top150.hashmap;

import java.util.*;

public class LC128 {
    public int longestConsecutive(int[] nums) {
            if (nums.length==0){
                return 0;
            }
            Arrays.sort(nums);
            HashSet<Integer> set = new HashSet<>();
            int longestConsecutiveNum = 1,max = 1;
            set.add(nums[0]);
            for (int i = 1 ; i<nums.length;i++){
                if (set.contains(nums[i])){
                    continue;
                }
                if (set.contains(nums[i]-1)){
                    longestConsecutiveNum++;
                }else {
                    longestConsecutiveNum=1;
                }
                max = Math.max(max,longestConsecutiveNum);
                set.add(nums[i]);
            }
            return max;
    }

    public static void main(String[] args) {
        LC128 lc = new LC128();
        int[] nums = {1,2,0,1};
        System.out.println(lc.longestConsecutive(nums));
    }
}
