package neetcode;

import java.util.ArrayList;

public class Intervall {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int[] cur  = newInterval;
        boolean isMerged = false;
        for(int i = 0 ; i < intervals.length; i++){
            if((cur[0] <=intervals[i][1] && cur[0] >=intervals[i][0]) || (cur[1] >= intervals[i][0] && cur[1] <= intervals[i][1])){
                cur[0] = Math.min(intervals[i][0], cur[0]);
                cur[1] = Math.max(intervals[i][1], cur[1]);
            }else if(cur[1] <intervals[i][0]){
                ans.add(cur);
                ans.add(intervals[i]);
                isMerged = true;
            }else{
                ans.add(intervals[i]);
            }

        }
        if(!isMerged){
            ans.add(cur);
        }
        return ans.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{9,10}};
        int[] newInterval = {6,7};
       // insert(intervals,newInterval);
        StringBuilder sb =  new StringBuilder();
        System.out.println(sb);
    }
}
