package lc.top150;

import java.util.Arrays;

public class LC189 {
    public void rotate(int[] nums, int k) {
       k = k % nums.length;
       reverse(nums,0,nums.length-1);//first reverse the whole array
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC189 lc = new LC189();
        int[] nums  = {1,2,3,4,5,6,7};
        int  k = 3;
        lc.rotate(nums,k);
    }
}
