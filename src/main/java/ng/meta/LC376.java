package ng.meta;

public class LC376 {
    static public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int start = 0;
        int count=1;
        while(start + 1 < nums.length && nums[start] == nums[start + 1]){
            start++;
        }
        if(start >= nums.length - 1){
            return count;
        }
        boolean flag = nums[start]>nums[start+1];
        count++;
        for (int i = start+1 ; i<nums.length-1; i++){
            if (nums[i]!=nums[i+1] && !flag == nums[i]>nums[i+1]){
                flag=!flag;
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
    }
}
