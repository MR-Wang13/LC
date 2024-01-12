package lc.backtracking;

import java.util.ArrayList;
import java.util.List;


public class CombinationSumIII {
    static List<List<Integer>> result = new ArrayList<>();
    static public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        backTracking(k,n,sum,1);
        return result;
    }

    private static void backTracking(int k, int n, List<Integer> sum, int i) {
        if (sum.size()>k){
            return;
        }
        if (sum.stream().mapToInt(Integer::intValue).sum() == n && sum.size()==k){
            result.add(new ArrayList<>(sum));
            return;
        }
        for (int j = i;j<=9;j++){
            sum.add(j);
            backTracking(k,n,sum,j+1);
            sum.remove(sum.size()-1);
        }

    }

    public static void main(String[] args) {
        combinationSum3(3,9);
    }
}
