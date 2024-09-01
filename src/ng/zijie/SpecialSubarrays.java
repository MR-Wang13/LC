package ng.zijie;

import java.util.HashMap;
import java.util.Map;

public class SpecialSubarrays {

    public static int countSpecialSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int left = 0; left < n; left++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int right = left; right < n; right++) {
                freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

                if (freqMap.size() > 2) {
                    break; // 不可能是特殊数组，跳出当前循环
                }

                if (isSpecialArray(freqMap)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isSpecialArray(Map<Integer, Integer> freqMap) {
        if (freqMap.size() != 2) {
            return false; // 必须有且仅有两种数字
        }

        // 检查是否有一种数字出现了一次
        int singleCount = 0;
        for (int freq : freqMap.values()) {
            if (freq == 1) {
                singleCount++;
            }
        }

        return singleCount == 1;
    }
    static int solution(int[] nums){
        int n = nums.length;
        int count =0;
        for (int left =0 ;left<n-2;left++){
            HashMap<Integer,Integer> freq = new HashMap<>();
            int sum =0;
            for (int right = left ; right<n;right++){
                freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);
                sum++;
                if (freq.size()>2){
                    break;
                }
                if (checkSpecial(freq,sum)){
                    System.out.println(freq);
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean checkSpecial(HashMap<Integer, Integer> freq, int sum) {
        if (freq.size()!=2 || sum<3){
            return false;
        }

        for (int f :freq.values()){
            if (f == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 4, 1, 4};
        System.out.println(solution(nums));
    }
}
