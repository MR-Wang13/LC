package ng.ziprecruiter;

import java.util.*;

public class FindSwappablePairs {
    public static List<int[]> findSwappablePairs(int[] numbers) {
        List<int[]> result = new ArrayList<>();
        HashMap<String,List<Integer>> group = new HashMap<>();
        for (int num:numbers){
            char[] number = String.valueOf(num).toCharArray();
            Arrays.sort(number);
            String key = String.valueOf(number);
            group.computeIfAbsent(key,k->new ArrayList<>()).add(num);
        }

        for (List<Integer> list : group.values()){
            if (list.size()<=1){
                continue;
            }
            for (int i = 0 ;i<list.size()-1 ; i++)
                for (int j = i+1 ; j<list.size();j++){
                    if (findSwapLessThanOne(list.get(i),list.get(j))){
                        result.add(new int[]{list.get(i),list.get(j)});
                    }
                }
        }
        return result;
    }

    private static boolean findSwapLessThanOne(Integer num1, Integer num2) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);

        if (s1.length() != s2.length()) {
            return false;  // They can't be swappable if the lengths differ
        }

        // Find mismatched positions
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }

        // If there are no differences, they are already equal
        if (diff.size() == 0) {
            return true;
        }

        // If there are exactly two differences, check if swapping them will make the numbers equal
        if (diff.size() == 2) {
            int pos1 = diff.get(0);
            int pos2 = diff.get(1);
            return s1.charAt(pos1) == s2.charAt(pos2) && s1.charAt(pos2) == s2.charAt(pos1);
        }

        // More than 2 differences means they can't be swapped with 1 swap
        return false;
    }

    public static List<int[]> findSwappablePairs1(int[] numbers) {
        List<int[]> result = new ArrayList<>();

        // Step 1: Group numbers that are made up of the same digits
        Map<String, List<Integer>> digitGroups = new HashMap<>();

        for (int num : numbers) {
            char[] digits = String.valueOf(num).toCharArray();
            Arrays.sort(digits);  // Sort the digits
            String key = new String(digits);
            digitGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(num);
        }

        // Step 2: For each group, check if any two numbers can be swapped within 1 swap
        for (List<Integer> group : digitGroups.values()) {
            for (int i = 0; i < group.size(); i++) {
                for (int j = i + 1; j < group.size(); j++) {
                    if (canBeSwappedWithinOneSwap(group.get(i), group.get(j))) {
                        result.add(new int[]{group.get(i), group.get(j)});
                    }
                }
            }
        }

        return result;
    }

    // Function to check if two numbers can be made equal with at most one swap
    private static boolean canBeSwappedWithinOneSwap(int num1, int num2) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);

        if (s1.length() != s2.length()) {
            return false;
        }

        // Find positions where the two numbers differ
        List<Integer> diffPositions = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffPositions.add(i);
            }
        }

        // If no differences or exactly two differences and they can be swapped
        return diffPositions.size() == 0 || (diffPositions.size() == 2 &&
                s1.charAt(diffPositions.get(0)) == s2.charAt(diffPositions.get(1)) &&
                s1.charAt(diffPositions.get(1)) == s2.charAt(diffPositions.get(0)));
    }
    public static void main(String[] args) {
        int[] numbers = {15, 51, 156, 165, 615, 1650};
        List<int[]> result = findSwappablePairs(numbers);

        // Print the result
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
