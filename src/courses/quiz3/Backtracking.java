package courses.quiz3;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static List<List<Integer>> generateSubsets(int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(1, n, currentSubset, subsets);
        return subsets;
    }
    public static void backtrack(int start, int n, List<Integer> currentSubset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = start; i <= n; i++) {
            currentSubset.add(i);
            backtrack(i + 1, n, currentSubset, subsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> subsets = generateSubsets(3);

        System.out.println("n=3 All Subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        System.out.println("n=3 Total number of subsets: " + subsets.size());


    }
}
