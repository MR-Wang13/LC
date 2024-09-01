package lc.top150.binarysearch;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0 , right = n-1;
        while (left<=right){
            int mid = left+ (right-left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC35 lc = new LC35();
        int[] nums = {1,3,5,6};
        System.out.println(lc.searchInsert(nums,5));
    }
}
