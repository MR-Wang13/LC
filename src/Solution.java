import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Solution {
    int[] nums;
    int[] original;

    public Solution(){};
    public Solution(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    public int[] shuffle() {
        int[] shuffled = new int[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(nums[i]);
        }
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = random.nextInt(list.size());
            shuffled[i] = list.remove(j);
        }
        System.arraycopy(shuffled, 0, nums, 0, nums.length);
        return nums;
    }

    public int minNumber(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);

        for (int i : nums1){
            List list =  Arrays.stream(nums2).boxed().collect(Collectors.toList());
            if (list.contains(i)){
                return i;
            }
        }

       if(nums1[0]>nums2[0]){
            return nums2[0]*10+nums1[0];
        }else {
            return nums1[0]*10+nums2[0];
        }
    }
    public void sort(int[] nums){
        for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3,5,2,6};
        int[] nums2 = {3,1,7};

        System.out.println( solution.minNumber(nums1,nums2));

    }
}
