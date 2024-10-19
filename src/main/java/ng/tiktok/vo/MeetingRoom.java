package ng.tiktok.vo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom {
    public static int meetingRoom2(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int roomsMax =0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int[] inter : intervals){
            while (!queue.isEmpty() && queue.peek() <= inter[0]){
                queue.poll();
            }
            queue.add(inter[1]);
            roomsMax = Math.max(roomsMax,queue.size());
        }
        return roomsMax;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        meetingRoom2(intervals);
    }
}
