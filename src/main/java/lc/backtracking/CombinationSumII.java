package lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    static List<List<Integer>> result = new ArrayList<>();
    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backTracking(candidates,target,list);
        return result;
    }

    private static void backTracking(int[] candidates, int target, List<Integer> list) {

        if (list.stream().mapToInt(Integer::intValue).sum() == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i<candidates.length; i++){
            if (i>0 && candidates[i] == candidates[i-1]){
                continue;
            }
            if (list.stream().mapToInt(Integer::intValue).sum() > target){
                break;
            }
            list.add(candidates[i]);
            backTracking(Arrays.copyOfRange(candidates,i+1,candidates.length),target,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates,target);
    }
}
