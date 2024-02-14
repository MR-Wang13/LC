package intern.snowflake;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxOrderVolume {
    int solution(int[] startTime, int[] endTime, int[] profit){
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i =0; i<n; i++){
            jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};
        }
        Arrays.sort(jobs,(a,b)->a[1]-b[1]);
        int[] dp = new int[n+1];
        for (int i=1; i<=n ;i++){
            int k = binarySearch(jobs,i-1,jobs[i-1][0]);
            dp[i] = Math.max(dp[i-1],dp[k]+jobs[i-1][2]);
        }
        return dp[n];
    }

    private int binarySearch(int[][] jobs, int r, int target) {
        int l = 0;
        while (l<r){
            int mid = l + (r-l)/2;
            if (jobs[mid][1]>=target){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] start = {10,5,15,18,30};
        int[] end = {40,17,35,53,65};
        int[] profit = {50,51,20,25,10};
        MaxOrderVolume m = new MaxOrderVolume();
        System.out.println(m.solution(start,end,profit));
    }
}
