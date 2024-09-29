package intern;

import java.util.Arrays;
import java.util.HashSet;

public class Test {
    /**
     * Example 1:
     *
     * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * Output: [2,2,2,1,4,3,3,9,6,7,19]
     * Example 2:
     *
     * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
     * Output: [22,28,8,6,17,44]
     * */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;
        for (int i = 0 ; i<arr2.length; i++){
            for (int j = 0; j<arr1.length; j++){
                if (arr1[j] == arr2[i]){
                    int temp =  arr1[j];
                    arr1[j] =  arr1[index];
                    arr1[index++] = temp;
                }
            }
        }

        Arrays.sort(arr1,index,arr1.length);

        return arr1;
    }
    /**
     * You have n dice, and each die has k faces numbered from 1 to k.
     *
     * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 1, k = 6, target = 3
     * Output: 1
     * Explanation: You throw one die with 6 faces.
     * There is only one way to get a sum of 3.
     *
     * */
    public int numRollsToTarget(int n, int k, int target) {
        int count = 0;
        return 0;
    }
    public static void main(String[] args) {
        int[] arr1 = {28,6,22,8,44,17}, arr2 = {22,28,8,6};
        Test test = new Test();
        test.relativeSortArray(arr1,arr2);
    }
}
