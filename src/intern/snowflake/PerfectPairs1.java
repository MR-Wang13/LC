package intern.snowflake;

import java.util.*;

public class PerfectPairs1 {
    public static int findPerfectPairs(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }
        Arrays.sort(arr); // Sort the array
        int count = 0; // Initialize count of perfect pairs

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];

            // Use binary search to find the boundary where the pair (x, y) stops being perfect
            int left = i + 1;
            int right = arr.length -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int y = arr[mid];

                if (isPerfectPair(x, y)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    result.add(list);
                    // If (x, y) is a perfect pair, all pairs (x, arr[left] to arr[mid]) are perfect
                    count += mid- left  + 1;
                    left = mid+1;
                } else {
                    // If not, discard the right half
                    right = mid - 1;
                }
            }
        }
        return count;
    }

    public static int findPerfectPairs1(int[] arr) {
        int count =0;
        for (int i = 0; i<arr.length; i++){
            arr[i]=Math.abs(arr[i]);
        }

        Arrays.sort(arr);
        for (int i = 0; i<arr.length;i++){
            int x = arr[i];
            int left = i+1;
            int right = arr.length-1;
            while (left<=right){
                int mid = left + (right-left)/2;
                int y = arr[mid];
                if (isPerfect(x,y)){
                    count+=mid-left+1;
                    left = mid +1;
                }else {
                    right= mid -1;
                }
            }
        }

        return count;
    }

    private static boolean isPerfect(int x, int y) {
        return Math.min(Math.abs(x-y),Math.abs(x+y))<=Math.min(Math.abs(x),Math.abs(y))&&
                Math.max(Math.abs(x-y),Math.abs(x+y))>=Math.max(Math.abs(x),Math.abs(y));
    }

    private static boolean isPerfectPair(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        return Math.min(Math.abs(x - y), Math.abs(x + y)) <= Math.min(absX, absY) &&
                Math.max(Math.abs(x - y), Math.abs(x + y)) >= Math.max(absX, absY);
    }

    public static void main(String[] args) {
        int[] arr = {2,5,-3,-5};
        System.out.println("The number of perfect pairs is: " + findPerfectPairs(arr));

    }
}
