package ng.gs;

public class TrappingRainWater {
    /**
     two point
     space complexity O(1)
    */
    public int trap(int[] height) {
        int n = height.length;
        int leftMaxBound = height[0];
        int rightMaxBound = height[n - 1];
        int totalTrappedWater = 0;
        int l = 0;
        int r = n - 1;
        while(l < r){
            if(height[l] < height[r]){
                l++;
                leftMaxBound = Math.max(leftMaxBound, height[l]);
                totalTrappedWater += leftMaxBound - height[l];
            }else{
                r--;
                rightMaxBound = Math.max(rightMaxBound, height[r]);
                totalTrappedWater += rightMaxBound - height[r];
            }
        }
        return totalTrappedWater;
    }
    /**
    use auxiliary array
     space complexity O(n)
     */
        public int trap1(int[] height) {
            int n = height.length;
            if (n == 0) {
                return 0;
            }

            int[] leftMax = new int[n];
            int[] rightMax = new int[n];

            leftMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return res;
        }

}
