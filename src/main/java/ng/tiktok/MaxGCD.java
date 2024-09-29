package ng.tiktok;

import java.util.*;

public class MaxGCD {

    // 求两个数的GCD
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 找到数组中任意两数对的最大GCD
    public static int findMaxGCD(int[] arr) {
        int maxGCD = 0;

        // 遍历数组中的每一个数对
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentGCD = gcd(arr[i], arr[j]);
                if (currentGCD > maxGCD) {
                    maxGCD = currentGCD;
                }
            }
        }

        return maxGCD;
    }
    static int findMaxGcd(int[] arr){
        int max = 0;
        for (int i = 0 ;i<arr.length-1;i++){
            max = Math.max(max,gcd(arr[i],arr[i+1]));
        }
        return max;
    }
    int findGcd(int a, int b){
        while (b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 15};
        System.out.println("数组中的最大GCD是: " + findMaxGcd(arr)); // 输出: 3

        int[] arr2 = {10, 20, 40, 60};
        System.out.println("数组中的最大GCD是: " + findMaxGcd(arr2)); // 输出: 20
    }
}
