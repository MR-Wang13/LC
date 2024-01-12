package lc.regular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L2610 {
    /**
    * 2610. Convert an Array Into a 2D Array With Conditions
     * Medium
     * Topics
     * Companies
     * Hint
     * You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
     *
     * The 2D array should contain only the elements of the array nums.
     * Each row in the 2D array contains distinct integers.
     * The number of rows in the 2D array should be minimal.
     * Return the resulting array. If there are multiple answers, return any of them.
     *
     * Note that the 2D array can have a different number of elements on each row.
    * */

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int max =0;
        for (int num : nums){
            int count = map.getOrDefault(num,0)+1;
            if (count>max){
                max = count;
            }
            map.put(num,count);
        }
        for (int i = 1 ; i<=max ;i++){
            List<Integer> list = new ArrayList<>();
            map.keySet().forEach(key ->{
                if (map.get(key)>0){
                    list.add(key);
                    map.put(key,map.get(key)-1);
                }
            });
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums ={1,3,4,1,2,3,1};
        findMatrix(nums);
    }
}
