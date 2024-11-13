package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BackTracking {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(nums, new ArrayList<Integer>(), result, new HashSet<Integer>(), 0);
        return result;
    }

    private static void backTracking(int[] nums, ArrayList<Integer> list, List<List<Integer>> result, HashSet<Integer> set, int n) {

        result.add(new ArrayList<>(list));

        for(int i = n ; i< nums.length; i++){

            list.add(nums[i]);
            backTracking(nums, list, result, set, i+1);
            list.remove(list.size()-1);
        }

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        backTrack(result, nums, 0, new ArrayList<Integer>(), set);
        return result;
    }
    public static void backTrack(List<List<Integer>> result, int[] nums, int index, ArrayList<Integer> list, HashSet<Integer> set) {
        if(index == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }


        result.add(new ArrayList<Integer>(list));
        for(int i = index; i < nums.length; i++){
            if(set.contains(nums[index])){
                return;
            }
            list.add(nums[i]);
            backTrack(result, nums, i + 1, list, set);
            list.remove(list.size() - 1);
        }
        set.add(nums[index]);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //subsets(nums);
        subsetsWithDup(new int[]{7,7});
    }
}
