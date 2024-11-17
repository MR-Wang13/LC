package ng.meta;

public class LC209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum  = 0;
        int min = Integer.MAX_VALUE;
        while (left <= right ){
            if(sum >= target){
                min = Math.min(min, right -left );
                sum -= nums[left++];
            }else{
                if(right >= n){
                    break;
                }
                sum+=nums[right++];
            }
        }
        return min == Integer.MAX_VALUE? 0:min;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 11;
        System.out.println(minSubArrayLen(target,nums));
    }
}
