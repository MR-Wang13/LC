package lc.top150.interval;

import java.util.ArrayList;
import java.util.List;

public class LC57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> lists = new ArrayList<>();
        for(int[] in : intervals){

            if(newInterval[1]<in[0]){
                lists.add(newInterval);
                newInterval = in;
            }else if(newInterval[0]>in[1]){
                lists.add(in);
            }else {
                newInterval[0] = Math.min(newInterval[0],in[0]);
                newInterval[1] = Math.max(newInterval[1],in[1]);
            }
        }
        lists.add(newInterval);


        return lists.toArray(new int[lists.size()][]);
    }
}
