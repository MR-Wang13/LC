package lc.top150.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC46 {
    List<List<Integer>> result;
    Set<Integer> sets ;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        sets = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        backTrackPermute(list,nums);
        return result;
    }

    private void backTrackPermute(List<Integer> list, int[] nums) {
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i : nums){
            if (sets.contains(i)){
                continue;
            }
            list.add(i);
            sets.add(i);
            backTrackPermute(list,nums);
            sets.remove(list.get(list.size()-1));
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LC46 lc = new LC46();
        System.out.println(lc.permute(nums));
    }

}
