package lc.top150;

public class LC55 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i =0; i<=cover ; i++){
            if (i+nums[i]>cover){
                cover = i+nums[i];
            }
            if (cover>=nums.length){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC55 lc = new LC55();
        int[] nums = {3,2,1,0,4};
        System.out.println(lc.canJump(nums));
    }
}
