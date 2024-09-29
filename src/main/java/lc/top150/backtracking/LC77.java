package lc.top150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        for (int i=1 ; i<=n; i++){
            com.add(i);
            backTrackCombination(n,k,i,com);
            com.remove(com.size()-1);
        }
        return result;
    }

    private void backTrackCombination(int n, int k, int i,List<Integer> com) {
        if (com.size() == k){
            result.add(new ArrayList<>(com));
            return;
        }
        for (int j = i+1 ; j<=n ; j++){
            com.add(j);
            backTrackCombination(n,k,j,com);
            com.remove(com.size()-1);
        }
    }

    public static void main(String[] args) {
        LC77 lc = new LC77();
        System.out.println(lc.combine(4,2));
    }
}
