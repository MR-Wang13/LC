package lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC491 {
    static public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(nums,0,list,result);
        return result;
    }

    private static void backTracking(int[] nums, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size()>1){
            result.add(new ArrayList<>(list));
        }
        if (k == nums.length){
            return;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =k ; i<nums.length;i++){
            if (map.getOrDefault(nums[i],0)==1){
                continue;
            }
            if (list.size()>0&&nums[i]<list.get(list.size()-1)){
                continue;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            list.add(nums[i]);
            backTracking(nums,i+1,list,result);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1,1};
        findSubsequences(nums);
    }
}
