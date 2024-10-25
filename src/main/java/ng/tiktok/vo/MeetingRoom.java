package ng.tiktok.vo;

import java.util.*;

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

    static class Room{
        int no;
        int usedTime;
        long availableTime;

        public Room(int no, int usedTime, long availableTime) {
            this.no = no;
            this.usedTime = usedTime;
            this.availableTime = availableTime;
        }
    }

    private static Room findRoom(int[] meeting, List<Room> list) {
        Room selectedRoom = null;

        // 遍历房间以找到最合适的房间
        for (Room room : list) {
            // 如果房间在会议开始时间前可用
            if (room.availableTime <= meeting[0]) {
                if (selectedRoom == null || room.no < selectedRoom.no) {
                    selectedRoom = room; // 选择编号最小的可用房间
                }
            }
        }

        // 如果没有找到完全可用的房间，选择最早可用的房间
        if (selectedRoom == null) {
            selectedRoom = list.get(0);
            for (Room room : list) {
                if (room.availableTime < selectedRoom.availableTime ||
                        (room.availableTime == selectedRoom.availableTime && room.no < selectedRoom.no)) {
                    selectedRoom = room; // 选择最早可用且编号最小的房间
                }
            }
        }
        return selectedRoom;
    }
    public static int meetingRoom3(int n, int[][] meetings) {
        List<Room> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Room(i,0,0));
        }
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        Queue<int[]> meetingQueue = new ArrayDeque<>(Arrays.asList(meetings));

        while (!meetingQueue.isEmpty()){
            int[] meeting = meetingQueue.poll();
            int durationTime = meeting[1] - meeting[0] ;
            Room room = findRoom(meeting,list);
            room.usedTime++;

            room.availableTime = Math.max(room.availableTime, meeting[0]) + durationTime;
        }

        int max = 0;
        int maxNo = -1;

        for (Room room : list){
            if(room.usedTime > max){
                max = room.usedTime;
                maxNo = room.no;
            }else if(room.usedTime == max && room.no < maxNo){
                maxNo = room.no;
            }
        }
        return maxNo;

    }




    public static void main(String[] args) {
        //{0,10},{1,9},{2,8},{3,7},{4,6}
        //int[][] intervals = {{1,20},{2,10},{3,5},{4,9},{6,8}};
        int[][] intervals = {{0,10},{1,9},{2,8},{3,7},{4,6}};

        meetingRoom3(3, intervals);
    }
}
