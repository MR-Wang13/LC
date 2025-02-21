package neetcode;

import java.util.*;

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
    public  static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backTrackingC2(candidates,new ArrayList<>(), target, result, 0, 0 );
        return result;
    }

    private static void backTrackingC2(int[] candidates, ArrayList<Integer> list, int target, List<List<Integer>> result, int sum, int n) {
        if(sum > target){
            return;
        }
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = n ; i <candidates.length; i++ ){
            if(i > n && candidates[i] == candidates[i - 1]){
                continue;
            }
            set.add(candidates[i]);
            list.add(candidates[i]);
            backTrackingC2(candidates,list, target, result, sum + candidates[i], i + 1 );
            list.remove(list.size() - 1);
        }
    }
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
            return true;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, int i, int j, int index) {

        if(index == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index) ){
            return false;
        }


        int[][] directs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        for(int[] direct : directs){
            int new_i = i + direct[0];
            int new_j = j + direct[1];

            if(search(board, word, new_i, new_j, index + 1)){
                return true;
            }


        }
        return false;
    }
    public static void main(String[] args) {
        /*int[] nums = {1,2,3};
        //subsets(nums);
        subsetsWithDup(new int[]{7,7});*/

        int[] candidates = {9,2,2,4,6,1,5};
        int target = 8;
        combinationSum2(candidates, target);
    }
}
