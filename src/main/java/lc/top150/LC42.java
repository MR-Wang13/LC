package lc.top150;

public class LC42 {
    public int trap(int[] height) {

        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int totalV = 0;
        left[0] = height[0];
        for (int i =1 ; i<n; i++){
            left[i] = Math.max(height[i],left[i-1]);
        }
        right[n-1] = height[n-1];
        for (int i =n-2 ; i>=0; i--){
            right[i] = Math.max(height[i],right[i+1]);
            totalV+=Math.min(left[i],right[i]) - height[i];
        }

        return totalV;
    }



    public static void main(String[] args) {
        LC42 lc = new LC42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(lc.trap(height));
    }
}
