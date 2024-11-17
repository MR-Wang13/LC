package ng.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        int[] cur = intervals[0];
        for(int i = 1 ; i < intervals.length; i++){
            int[] next = intervals[i];
            if(cur[1] < next[0]){
                ans.add(cur);
                cur = next;
            }else {
                cur[1] = Math.max(cur[1],next[1]);
            }
        }
        ans.add(cur);
        return ans.toArray(new int[][]{});
    }
}
