package ng.meta;

import java.util.HashMap;
import java.util.Map;

public class LC560 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int num : nums){
            sum+=num;
            int remove = sum - k;
            count += prefixSumMap.getOrDefault(remove,0);
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums, 2));
    }
}
