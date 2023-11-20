package lc.doublePoint;

public class removeInArr {
    int remove(int[] nums, int target){
        int slow =0;
        for (int n : nums){
            if (n!=target){
                nums[slow++] = n;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int target =2;
        removeInArr removeInArr = new removeInArr();
        System.out.println(removeInArr.remove(nums,target));

    }
}
