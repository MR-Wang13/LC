package neetcode;

import java.util.*;

public class ArrayHash {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((e1, e2)-> Integer.compare(e2.getValue(), e1.getValue()));
        queue.addAll(frequency.entrySet());
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = queue.poll().getKey();
        }

        return result;
    }
    public static boolean isValidSudoku(char[][] board) {
            int[][][] validBox = new int[3][3][9];
            int[][] validCol = new int[9][9];
            int[][] validRow = new int[9][9];
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){

                    if(board[i][j] == '.'){
                        continue;
                    }
                    int num = Character.getNumericValue(board[i][j])-1;
                    if(validCol[i][num] == 1 || validRow[j][num] == 1 || validBox[i/3][j/3][num] == 1){
                        return false;
                    }
                    validCol[i][num] = 1;
                    validRow[j][num] = 1;
                    validBox[i/3][j/3][num] = 1;
                }
            }
            return true;

    }

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            if(numbers[left]+numbers[right] == target){
                return new int[]{left+1, right+1};
            }else if(numbers[left]+numbers[right] > target){
                right = binarySearchR(numbers,left,right-1,target - numbers[left]);
            }else{
                left = binarySearchL(numbers,left+1,right,target - numbers[right]);
            }
        }
        return new int[]{left+1, right+1};
    }
    public static int binarySearchR(int[] numbers, int left, int right, int target) {
        while(left <= right){
            int mid = left + (right - left)/2;
            if(numbers[mid] == target){
                return mid;
            }else if(numbers[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;

    }
    public static int binarySearchL(int[] numbers, int left, int right, int target) {
        while(left <= right){
            int mid = left + (right - left)/2;
            if(numbers[mid] == target){
                return mid;
            }else if(numbers[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;

    }
    static int max = 0;
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == 0 || n == 1 || n <= k){
            return n;
        }
        int left = 0;
        int right = 0;
        int maxVal = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < n){
            if(n - left + 1 <= maxLength){
                return maxLength;
            }
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxVal = Math.max(maxVal, map.get(c));
            int windowSize = right - left + 1;
            if(windowSize - maxVal <= k){
                maxLength = Math.max(maxLength, windowSize);
            }else {
                map.put(s.charAt(left),map.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s="KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int  k=4;
        System.out.println(characterReplacement(s,k));
    }

}
