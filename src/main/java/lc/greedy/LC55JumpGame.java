package lc.greedy;

public class LC55JumpGame {
    //递归超时
    public boolean canJump(int[] nums) {
        if(nums.length<=1 ){
            return true;
        }
        if (backTracking(0,nums)){
            return true;
        };
        return false;
    }

    private boolean backTracking(int l, int[] nums) {
        if (l+nums[l]>=nums.length-1){
            return true;
        }
        for (int i = l+1; i<=l + nums[l]; i++){
            if (backTracking(i,nums)){
                return true;
            }
        }
        return false;

    }
    /***
     *
     *遍历一遍数组 不停更新覆盖范围
     * */
    public boolean canJump1(int[] nums) {
        int cover= 0;
        for (int i = 0; i<nums.length; i++){
            cover = Math.max(cover,i+nums[i]);
            if (cover>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LC55JumpGame lc = new LC55JumpGame();
        int[] nums = {3,2,1,0,4};
        System.out.println(lc.canJump(nums));
    }
}
