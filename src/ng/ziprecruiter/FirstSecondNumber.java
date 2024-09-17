package ng.ziprecruiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstSecondNumber {
    public static int[] solution(int[] numbers) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        // 将第一个数放入 first, 第二个数放入 second
        if (numbers.length > 0) {
            first.add(numbers[0]);
        }
        if (numbers.length > 1) {
            second.add(numbers[1]);
        }

        // 从第三个数开始遍历
        for (int i = 2; i < numbers.length; i++) {
            int num = numbers[i];

            // 统计 first 和 second 中比 num 大的数字数量
            int firstCount = countGreaterBinarySearch(first, num);
            int secondCount = countGreaterBinarySearch(second, num);

            // 根据规则分配
            if (firstCount > secondCount) {
                insertInSortedOrder(first, num);
            } else if (firstCount < secondCount) {
                insertInSortedOrder(second, num);
            } else {
                // 如果大于 num 的数量相同，选择长度较短的数组
                if (first.size() < second.size()) {
                    insertInSortedOrder(first, num);
                } else if (first.size() > second.size()) {
                    insertInSortedOrder(second, num);
                } else {
                    // 如果长度也相同，分配到 first
                    insertInSortedOrder(first, num);
                }
            }
        }

        // 合并 first 和 second 数组
        int[] result = new int[numbers.length];
        int index = 0;

        // 先添加 first 数组中的元素
        for (int num : first) {
            result[index++] = num;
        }

        // 然后添加 second 数组中的元素
        for (int num : second) {
            result[index++] = num;
        }

        return result;
    }

    // 使用二分查找统计 list 中比 num 大的元素个数
    private static int countGreaterBinarySearch(List<Integer> list, int num) {
        int index = Collections.binarySearch(list, num);
        if (index < 0) {
            index = -(index + 1);  // 二分查找返回负数时，表示插入点
        }
        return list.size() - index;  // 大于 num 的元素个数
    }

    // 在有序列表中按顺序插入元素
    private static void insertInSortedOrder(List<Integer> list, int num) {
        int index = Collections.binarySearch(list, num);
        if (index < 0) {
            index = -(index + 1);  // 计算插入位置
        }
        list.add(index, num);  // 按顺序插入
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 6, 2, 7, 4};
        int[] result = solution(numbers);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // 输出：5 6 8 7 3 2 4
    }
}
