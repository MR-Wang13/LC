package lc.top150;

import java.util.HashMap;

public class LC169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            int count = map.getOrDefault(nums[i],0);
            count++;
            if (count>nums.length/2){
                return nums[i];
            }
            map.put(nums[i],count);
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
