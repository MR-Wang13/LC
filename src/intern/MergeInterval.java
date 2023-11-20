package intern;

import java.util.Arrays;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
        int[][] result =  new int [intervals.length][intervals[0].length];
        int start = intervals[0][0];
        int end = intervals[0][1];
        int index = 0;
            for (int j = 1; j < intervals.length; j++) {
                if (intervals[j][0] > end) {
                    result[index][0] = start;
                    result[index][1] = end;
                    end = intervals[j][1];
                    start = intervals[j][0];
                    index++;

                }else if( intervals[j][0] <= end && intervals[j][1]>= end) {
                    end = intervals[j][1];

                }
            }

        int[][] newResult = new int[index+1][intervals[0].length];
        for (int k = 0 ; k<index ; k++){
            newResult[k][0] = result[k][0];
            newResult[k][1] = result[k][1];
        }
        newResult[index][0] =  intervals[intervals.length-1][0];
        newResult[index][1] =  intervals[intervals.length-1][1];

        return newResult;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{5,6}};
        MergeInterval interval = new MergeInterval();
        interval.merge(intervals);
    }
}
