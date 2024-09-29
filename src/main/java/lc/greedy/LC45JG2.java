package lc.greedy;

public class LC45JG2 {
    int min = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        if(nums.length<=1 ){
            return 0;
        }
        int count = 0;
        backTracking(0,nums,count);
        return min;
    }
    private void backTracking(int l, int[] nums, int count) {
        if (l + nums[l] >= nums.length - 1) {
            count++;
            min = Math.min(min, count);
            return;
        }
        for (int i = l + 1; i <= l + nums[l]; i++) {
            backTracking(i, nums, count + 1);
        }

    }

    public static void main(String[] args) {
        LC45JG2 lc = new LC45JG2();
        int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        System.out.println(lc.jump(nums));
    }
}
