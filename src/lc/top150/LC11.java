package lc.top150;

public class LC11 {
    //
    public int maxArea(int[] height) {
        int n = height.length;
        int maxAmount = 0;
        int left = 0, right = n-1;
        while (left<right) {
            maxAmount = Math.max(maxAmount, Math.min(height[left], height[right]) * (right - left));
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxAmount;
    }

    public static void main(String[] args) {
        LC11 lc = new LC11();
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(lc.maxArea(h));
    }
}
