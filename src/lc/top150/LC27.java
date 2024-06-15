package lc.top150;

public class LC27 {
    public int removeElement(int[] nums, int val) {
        int k = 0 ;
        for (int i = 0 ; i<nums.length ; i++){
            if (nums[i]!=val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        LC27 lc = new LC27();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        lc.removeElement(nums,val);
    }
}
