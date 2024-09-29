package lc.regular;

import java.util.*;

public class LC907 {

    // backtracking always lead to timeout
    /*

    int sum = 0;
    public int sumSubarrayMins(int[] arr) {
        sum = 0;
        Queue<Integer> queue  = new PriorityQueue<>();
        for (int i =1; i<=arr.length; i++) {
            queue.clear();
            countSub(0, arr, queue,i);
        }
        sum = sum % MOD;
        return sum;
    }

    private void countSub(int k, int[] arr,Queue<Integer> queue,int length) {

        for (int i =k; i<arr.length; i++){
            queue.add(arr[i]);

            if (length == queue.size()){
                sum+=queue.peek();
                queue.remove(arr[i - length + 1]);
            }
        }
    }*/
    /***
     * 单调栈
     *
     * */
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;

        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<>();
        long ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i<n; i++){
            while (!monoStack.isEmpty() && arr[i]<=arr[monoStack.peek()]){
                monoStack.pop();
            }
            left[i] = i-(monoStack.isEmpty()?-1:monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();

        for (int i = n-1; i>=0; i--){
            while (!monoStack.isEmpty() && arr[i]<arr[monoStack.peek()]){
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty()?n:monoStack.peek()) -i;
            monoStack.push(i);
        }
        for (int i = 0; i<n; i++){
            ans += (long)arr[i]*left[i]*right[i] % MOD;
        }
        return (int) ans;
    }

        public static void main(String[] args) {
        LC907 lc907 = new LC907();
        int[] nums = {3,1,2,4};
        System.out.println(lc907.sumSubarrayMins(nums));
    }
}
