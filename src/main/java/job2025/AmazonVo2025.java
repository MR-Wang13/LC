package job2025;


import java.util.Arrays;

public class AmazonVo2025 {
    // lc 875
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int maxNum = piles[piles.length - 1];
        int l = 1, r = maxNum,min = r;
        while (l <= r){
            int mid = l + (r - l)/2;
            if(canFinish(piles,mid,h)){
                min = mid;
                r = mid-1;
            }else {
                l = mid + 1;
            }
        }
        return min;
    }

    private boolean canFinish(int[] piles, int mid, int h) {
        long totalHour = 0;
        for(int num : piles){
            if(num <= mid){
                totalHour++;
            }else {
                totalHour+= ((num + mid -1)/mid);
            }
        }
        return totalHour<=h;
    }

    public static void main(String[] args) {
        ng.amazon.vo2025.Vo2025 lc = new ng.amazon.vo2025.Vo2025();
        int[] piles = {30,11,23,4,20};
        piles = new int[]{805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(lc.minEatingSpeed(piles,h));
    }
}


