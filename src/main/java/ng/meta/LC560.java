package ng.meta;

public class LC560 {
    public static int subarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = nums[right];
        int count = 0;
        while (left <= right ){
            if(sum == k){
                count++;
                sum-=nums[left++];
            }else if(sum > k){
                sum-=nums[left++];
            }else {

                right++;
                if(right == nums.length){
                    break;
                }
                sum+=nums[right];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subarraySum(nums, 2));
    }
}
