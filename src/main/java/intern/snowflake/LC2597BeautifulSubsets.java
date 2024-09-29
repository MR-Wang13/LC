package intern.snowflake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2597BeautifulSubsets {
    int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        count = 0;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i<nums.length; i++){
            list.add(nums[i]);
            backTracking(nums,i+1,list,k);
            list.remove(list.size()-1);
        }
        return count;
    }

    private void backTracking(int[] nums, int m, List<Integer> list,int k) {
        count++;
        if (m== nums.length){
            return;
        }

        for (int i = m ; i<nums.length; i++){
            if (checkValid(nums[i],list,k)){
                continue;
            }

            list.add(nums[i]);
            backTracking(nums,i+1,list,k);
            list.remove(list.size()-1);
        }
    }

    private boolean checkValid(int num, List<Integer> list, int k) {
        for(int i = list.size()-1; i>=0 ; i--){
           int diff = Math.abs(list.get(i)-num);
           if (diff > k) {
               return false;
           }
           if (diff==k){
               return true;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        LC2597BeautifulSubsets lc = new LC2597BeautifulSubsets();
        int[] nums = {10,4,5,7,2,1};
        int k =3;
        System.out.println(lc.beautifulSubsets(nums,k));
    }
}
