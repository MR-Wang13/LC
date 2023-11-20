package lc.ArrayTest;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int mid = nums.length/2;
        int left = 0;
        int right = nums.length-1;
        while (left!=right){
            if(target==nums[mid]){
                return mid;
            }else if (target>nums[mid]){
                left = mid+1;
                mid =  left + (right-left)/2;
            }else {
                right = mid-1;
                mid =  left + (right-left)/2;
            }
        }
        if (nums[left]==target){
            return left;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[]  nums = {-1};
        int target = 9;

        target = 2;
        BinarySearch search = new BinarySearch();
        System.out.println(search.search(nums,target));
    }
}
