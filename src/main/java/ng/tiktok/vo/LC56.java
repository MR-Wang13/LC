package ng.tiktok.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        if(intervals.length<=1){
            return intervals;
        }
        int[] cur = intervals[0];
        List<int[]> ans = new ArrayList<>();
        for(int i =1 ;i<intervals.length;i++){
            int[] next = intervals[i];
            if(cur[1]<next[0]){
                ans.add(cur);
                cur = next;
            }else{
                cur[1] = Math.max(cur[1],next[1]);
            }
        }
        ans.add(cur);
        return ans.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
    }
}
