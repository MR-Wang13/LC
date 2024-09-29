package intern.tiktok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumUniqueArraySum {
    static int findAndReplaceMini(int[] nums){
        Arrays.sort(nums);
        int i = 0;
        while (i<nums.length) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                findNextMiniNum(nums, i);
            }else {
                i++;
            }

        }
        return Arrays.stream(nums).sum();
    }

    private static void findNextMiniNum(int[] nums, int i) {
        int pos = -1;
        int minSum = -1;
        for (int j = i;j<nums.length;j++){
            if (j>i && nums[j]-nums[j-1]>1){
                pos =j-1;
                minSum =nums[j-1]+1;
                break;
            }
        }
        if (pos == -1){
            pos = nums.length-1;
            minSum = nums[nums.length-1]+1;
        }
        for (int k = i;k<=pos;k++){
            if (k==pos){
                nums[k]=minSum;
            }else {
                nums[k] = nums[k + 1];
            }

        }

    }

    public static int minUniqueSum(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> seen = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            while (seen.contains(arr[i])) {
                arr[i]++;
            }
            seen.add(arr[i]);
            sum += arr[i]; 
        }

        return sum; // 返回总和
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 7};
        System.out.println(minUniqueSum(nums));
    }
}
