package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static List<List<Integer>> result = new ArrayList<>();

    static int N=0;
    static public List<List<Integer>> combine(int n, int k) {
        N=n;
        for (int i=1;i<=N;i++) {
            List<Integer> list = new ArrayList<>();
            backTracking(i, k, list);
        }
        return result;
    }

    private static void backTracking(int n, int k, List<Integer> list) {
        list.add(n);
        if (list.size()==k){
            List<Integer> temp  = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        for (int i = n+1 ; i<=N ; i++){
            backTracking(i,k,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        combine(4,2);
    }
}
