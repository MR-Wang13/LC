package lc.top150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC39 {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        backtrackingComSum(candidates,target,sum,list,0);
        return result;
    }

    private void backtrackingComSum(int[] candidates, int target, int sum, List<Integer> list, int k) {
        if (sum>target){
            return;
        }
        if (sum == target ){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i =k ; i<candidates.length; i++){
            list.add(candidates[i]);
            sum +=candidates[i];
            backtrackingComSum(candidates,target,sum,list, i);
            sum-=candidates[i];
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        LC39 lc = new LC39();
        int[] sum = {2,3,6,7};
        int target = 7;
        System.out.println(lc.combinationSum(sum,target));
    }
}
