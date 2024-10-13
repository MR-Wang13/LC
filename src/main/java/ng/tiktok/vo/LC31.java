package ng.tiktok.vo;

public class LC31 {
    public void nextPermutation(int[] nums) {
       int i = nums.length-2;
       while (i>=0 && nums[i]>=nums[i+1]){
           i--;
       }
       if(i>=0) {
           int j = nums.length - 1;
           while (j >= 0 && nums[j] <= nums[i]) {
               j--;
           }
           swap(nums,i,j);
       }

       reverse(nums,i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        LC31 lc = new LC31();
        int[] nums = {1,2,3};
        lc.nextPermutation(nums);
    }
}
/*
1234 1243 1324 1342 1423 1432
2134*/
