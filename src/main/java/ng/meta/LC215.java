package ng.meta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class LC215 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(pq.size() < k){
                pq.offer(num);
            }else {
                if(num > pq.peek()){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.peek();
    }
    public static int findKthLargest1(int[] nums, int k) {
        int left = 0 , right = nums.length -1;
        Random random = new Random();
        while (left < right){
            int pivot_index = left + random.nextInt(right - left + 1);
            int sortedIndex = patition(nums, left ,right, pivot_index);
            if(sortedIndex == nums.length - k){
                return nums[sortedIndex];
            }else if (sortedIndex < nums.length - k){
                left = sortedIndex + 1;
            }else {
                right = sortedIndex - 1;
            }
        }
        return -1;
    }

    private static int patition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storedIndex = left;
        for(int i = left ; i < right; i++){
            if(nums[i] < pivot){
                swap(nums, storedIndex, i);
                storedIndex++;
            }
        }
        swap(nums, storedIndex , right);
        return storedIndex;
    }

    private static void swap(int[] nums, int pivotIndex, int right) {
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest1(nums, k));
    }
}
