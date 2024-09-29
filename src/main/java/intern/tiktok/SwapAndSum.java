package intern.tiktok;

import java.util.ArrayList;
import java.util.List;

public class SwapAndSum {

    public static long maxEfficiency(int n, int[] memory) {
        long maxEfficiency = 0;
        long mod = 1000000007;

        // Iterate through all possible idx values
        for (int idx = 1; idx <= n / 2; idx++) {
            // Try swapping elements at positions i and n-i-1 if it increases the efficiency
            for (int i = 0; i < idx; i++) {
                int swapIdx = n - i - 1;
                if (memory[i] * (i + 1) + memory[swapIdx] * (swapIdx + 1) < memory[swapIdx] * (i + 1) + memory[i] * (swapIdx + 1)) {
                    // Swap elements
                    int temp = memory[i];
                    memory[i] = memory[swapIdx];
                    memory[swapIdx] = temp;
                }
            }
            // Calculate the efficiency after each swap
            long currentEfficiency = 0;
            for (int i = 0; i < n; i++) {
                currentEfficiency = (currentEfficiency + ((long) memory[i] * (i + 1))) % mod;
            }
            // Update the maximum efficiency
            maxEfficiency = Math.max(maxEfficiency, currentEfficiency);
        }
        return maxEfficiency;
    }
    static int maxEfficiency(List<Integer> memory){
        int n = memory.size();
        int maxNum = 0;
        for (int idx = n/2;idx>0; idx--){
            maxNum = Math.max(maxNum,Swap(idx,memory));
        }
        return maxNum;
    }

    private static int Swap(int idx, List<Integer> memory) {
        int left = 0;
        int right = memory.size()-1;
        int index = 1;
        while (index<=idx){
            int t = memory.get(left);
            memory.set(left,memory.get(right));
            memory.set(right,t);
            left++;right--;
            index++;
        }
        int sum =0;
        for (int i=0;i<memory.size();i++){
            sum+= (i+1)*memory.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,4,2,4,1,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0 ; i<nums.length;i++){
            list.add(nums[i]);
        }
        System.out.println( maxEfficiency(nums.length,nums));
    }
}
