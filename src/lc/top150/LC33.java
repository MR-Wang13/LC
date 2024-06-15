package lc.top150;

public class LC33 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;

            if (nums[mid] == target){
                return mid;
            }
            if (nums[left]<=nums[mid]){
                if (nums[left]>target||nums[mid]<target){
                    left = mid +1;
                }else {
                    right = mid-1;
                }
            }else {
                if (nums[left]>target&&nums[mid]<target){
                    left=mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC33 lc = new LC33();
        int[] nums ={1,3};
        System.out.println(lc.search(nums,3));
    }


}
