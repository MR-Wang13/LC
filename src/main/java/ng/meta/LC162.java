package ng.meta;

public class LC162 {
    public int findPeakElement(int[] nums) {
        // 1 2 1 2 3 4 5
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
