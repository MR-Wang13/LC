package intern.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingScheduler {
    public static void main(String[] args) {
        int[][][] schedules = {
                {{5, 6}, {1, 2}, {3, 4}},
                {{7, 8}, {5, 6}},
                {{6, 7}, {2, 3}},
                {{0, 1}, {4, 5}}
        };
        int k = 1;
        System.out.println("Earliest available time: " + meeting(schedules, k));
    }

    public static int meeting(int[][][] schedules, int k) {
        List<int[]> allBusyTimes = new ArrayList<>();

        // 收集所有忙碌的时间段
        for (int[][] employeeSchedule : schedules) {
            allBusyTimes.addAll(Arrays.asList(employeeSchedule));
        }

        // 按开始时间排序
        allBusyTimes.sort((a, b) -> Integer.compare(a[0], b[0]));

        // 合并重叠的忙碌时间段
        List<int[]> mergedBusyTimes = new ArrayList<>();
        int[] current = allBusyTimes.get(0);
        for (int i = 1; i < allBusyTimes.size(); i++) {
            int[] next = allBusyTimes.get(i);
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                mergedBusyTimes.add(current);
                current = next;
            }
        }
        mergedBusyTimes.add(current);

        // 寻找空闲时间段
        int endOfLastBusy = 0;
        for (int[] busy : mergedBusyTimes) {
            if (busy[0] - endOfLastBusy >= k) {
                return endOfLastBusy;
            }
            endOfLastBusy = busy[1];
        }

        // 如果所有忙碌时间段之后的空闲时间满足要求
        return endOfLastBusy;
    }
}
