package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static List<List<Integer>> result = new ArrayList<>();
    static int count =0;
    static int N=0;
    static public List<List<Integer>> combine(int n, int k) {
        count =0;
        N=n;
        List<Integer> list = new ArrayList<>();
        backTracking(1, k, list);

        return result;
    }

    private static void backTracking(int n, int k, List<Integer> list) {
        if (list.size()==k){
            List<Integer> temp  = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        for (int i = n ; i<= N ; i++){
            count++;
            list.add(i);
            backTracking(i+1,k,list);
            list.remove(list.size()-1);
        }
    }

    static public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking1(1,n,k,result,list);
        return result;
    }

    private static void backTracking1(int t, int n, int k, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i =t ; i<=n ; i++){
            list.add(i);
            backTracking1(i+1,n,k,result,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        combine1(4,2);
    }
}
