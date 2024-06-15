package lc.newP.doubleLinkList;

public class LC26 {
    /**
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * */
    public int removeDuplicates(int[] nums) {
        int slow =0;
        for (int i = 0 ; i < nums.length; i++){
            if (i<nums.length-1 && nums[i] == nums[i+1]){
               continue;
            }else {
                nums[slow++]=nums[i];
            }
        }



       return slow;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        LC26 lc26 = new LC26();
        System.out.println(lc26.removeDuplicates(nums));
        System.out.println(lc26.removeDuplicates1(nums));

    }
}
