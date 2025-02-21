package ng.gs;

import java.util.Random;

public class FindKthLargest {
    /**
     *
     * partition
     * tc: O(n) average
     * */
    public static int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random random = new Random();
        while(left < right){
            int selectedIndex = left + random.nextInt(right - left + 1);
            int storedIndex = partition(nums,left,right,selectedIndex);
            if(storedIndex == nums.length - k){
                return nums[storedIndex];
            }else if (storedIndex > nums.length - k){
                right = storedIndex - 1;
            }else {
                left = storedIndex+1;
            }
        }

        return nums[left];
    }

    private static int partition(int[] nums, int left, int right, int selectedIndex) {
        int pivot = nums[selectedIndex];

        swap(nums,selectedIndex,right);
        int index = left;
        for(int i = left; i < right; i++){
            if(nums[i] < pivot){
                swap(nums, i , index);
                index++;
            }
        }

        swap(nums,index,right);

        return index;

    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
