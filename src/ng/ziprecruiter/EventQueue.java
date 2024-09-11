package ng.ziprecruiter;

import java.util.LinkedList;
import java.util.Queue;

public class EventQueue {
    public static int[] solution(int[] times) {
        int n = times.length;
        if (n == 0){
            return null;
        }
        int[] result = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        while (queue.size()<=10&&i<n){
            queue.offer(times[i++]);
        }
        int index=0;
        result[index++] = queue.poll()+300;

        while (!queue.isEmpty()){
            int arrivalTime = queue.poll();
            result[index] =arrivalTime+300<result[index-1]+300?result[index-1]+300:arrivalTime+300;
            index++;
            if (i<n){
                queue.offer(i++);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] times = {4, 400, 450, 500};
        solution(times);
    }
}
