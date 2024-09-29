package lc.top150.interval;

import java.util.Arrays;
import java.util.Comparator;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length, n = intervals[0].length;
        int[][] result = new int[m][n];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        result[0] = intervals[0];
        int index = 0;
        for (int i = 1 ; i<m ; i++){
            if (result[index][1]<intervals[i][0]){
                index++;
                result[index] = intervals[i];
            }else {
                result[index][1] = Math.max(result[index][1],intervals[i][1]);
            }
        }

        return Arrays.copyOf(result,index+1);

    }

    public static void main(String[] args) {
        LC56 lc  = new LC56();
        int[][] intervals = {{1,3},{2,6},{8,10},{12,18}};
        System.out.println(lc.merge(intervals));
    }
}
