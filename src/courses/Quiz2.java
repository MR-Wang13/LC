package courses;

import java.util.*;

public class Quiz2 {
    public static List<Integer> howSum(int targetSum, int[] numbers) {


        if (targetSum < 0) {
            return null;
        }

        if (targetSum == 0) {
            return new ArrayList<>();
        }


        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> list = howSum(remainder, numbers);
            if (list != null) {
                list.add(num);
                return list;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum(300, new int[]{7, 14}));
    }
}
