package lc.top150;

import java.math.BigDecimal;

public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int productOfAll  = 1;
        int zeroCount = 0;
        for (int i: nums){
            if (i!=0){
                productOfAll = productOfAll*i;
            }else {
                zeroCount++;
            }
        }
        for (int i = 0 ; i<nums.length;i++){
            if (zeroCount>1){
                result[i] = 0;
            }else if(zeroCount==1){
                if (nums[i]!=0){
                    result[i] = 0;
                }else {
                    result[i] = productOfAll;
                }
            }else {
                result[i] = productOfAll/nums[i];
            }

        }

        return result;
    }

    public static void main(String[] args) {
        LC238 lc = new LC238();
        int[] nums = {-1,1,0,-3,3};
        System.out.println(lc.productExceptSelf(nums));
    }
}
