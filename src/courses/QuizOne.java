package courses;

import java.util.ArrayList;
import java.util.List;

public class QuizOne {
    public void subSets(int[] nums){
        List<List<Integer>> lists = new ArrayList<>(); // collection of subset
        lists.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            int size = lists.size();
            for(int j = 0; j < size; j++){
                List<Integer> newList = new ArrayList<>(lists.get(j));
                newList.add(nums[i]);
                if (newList.size()==3){
                    newList.forEach(System.out::print);
                    System.out.print(",");
                }
                lists.add(newList);
            }
        }
    }
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets1(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
    public static void main(String[] args) {
        QuizOne quizOne = new QuizOne();
        int[] case1 = {1,2,3,4};
        int[] case2 = {7,3};
        int[] case3 = {4, 1, 7, 4, 3, 9, 1, 5};
        List<List<Integer>> res = new ArrayList<>();

        quizOne.subsets1(case1);
        //quizOne.subSets(case2);
        //quizOne.subSets(case3);


    }
}
