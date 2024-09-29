package ng.zijie;

import java.util.Arrays;
import java.util.Scanner;

public class MinDifference {

    public static int findMinDifference(int n, int k, int[] a) {
        Arrays.sort(a);  // 对糖果数量进行排序
        long total_sum = 0;

        for (int i = 0; i < n; i++) {
            total_sum += a[i];
        }

        long minDifference = Long.MAX_VALUE;

        // 枚举第一个糖果堆
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;

            // 使用双指针寻找最优的第二个糖果堆
            while (left <= right) {
                int mid = (left + right) / 2;
                long x = a[i] + a[mid];  // 小笨拿走的糖果总数
                long diff = Math.abs((k + 1) * x - total_sum);

                minDifference = Math.min(minDifference, diff);

                // 调整指针位置
                if ((k + 1) * x < total_sum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return (int) minDifference;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 1;
        int[] a = {2,2,3,4,5};



        System.out.println(findMinDifference(n, k, a));
    }
}

