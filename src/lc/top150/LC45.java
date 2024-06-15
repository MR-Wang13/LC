package lc.top150;

public class LC45 {
    public int jump(int[] nums) {
        int steps = 0;
        int max = 0;
        int cur = 0;
        for (int i =0 ; i<nums.length-1; i++){
            max = Math.max(i+nums[i],max);
            if (i == cur){
                steps++;
                cur = max;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        LC45 lc = new LC45();
        int[] nums = {2,3,1,1,4};
        System.out.println(lc.jump(nums));
    }
}
