package lc.ArrayTest;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int newIndex = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]!=val){
                nums[newIndex]=nums[i];
                newIndex++;
            }
        }
        return newIndex;
    }

    public static void main(String[] args) {
        RemoveElement element = new RemoveElement();
        int[] nums = {3,2,2,3}; int  val = 3;
        System.out.println(element.removeElement(nums,val));
    }
}
