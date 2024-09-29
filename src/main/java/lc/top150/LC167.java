package lc.top150;

public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left =0 , right=numbers.length-1;
        while (left<right){
            if (numbers[left]+numbers[right]==target){
                result[0] = left+1;
                result[1] = right+1;
                return result;
            }else if (numbers[left]+numbers[right]>target){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC167 lc = new LC167();
        int[] numbers = {2,3,4};
        System.out.println(lc.twoSum(numbers,6));
    }
}
