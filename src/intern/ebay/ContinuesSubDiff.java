package intern.ebay;

public class ContinuesSubDiff {
        public static int[] longestSubarray(int[] numbers, int diff) {
            int n = numbers.length;
            int left = 0, right = 0;
            int maxLen = 0;
            int[] result = new int[2];

            while (right < n) {
                boolean valid = true;
                for (int i = left; i < right; i++) {
                    if (Math.abs(numbers[i] - numbers[i+1]) > diff) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        result[0] = left;
                        result[1] = right;
                    }
                    right++;
                } else {
                    left++;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int[] numbers1 = {-1, 4, 6, 2, 8, 4, 7, 12};
            int diff1 = 5;
            int[] result1 = longestSubarray(numbers1, diff1);
            System.out.println("[" + result1[0] + ", " + result1[1] + "]");  // [0, 3]

            int[] numbers2 = {33, 13, 15, 22, 29, 26, 3, 7};
            int diff2 = 4;
            int[] result2 = longestSubarray(numbers2, diff2);
            System.out.println("[" + result2[0] + ", " + result2[1] + "]");  // [1, 2]
        }


}
