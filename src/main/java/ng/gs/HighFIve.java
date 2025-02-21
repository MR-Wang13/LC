package ng.gs;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFIve {
    public static int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for(int[] item : items){
            int id = item[0], score = item[1];
            map.computeIfAbsent(id, k -> new PriorityQueue<>()).offer(score);
            PriorityQueue<Integer> pq = map.get(id);
            if(pq.size() > 5){
                pq.poll();
            }
        }

        int[][] res = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
            int avg = entry.getValue().stream().mapToInt(Integer::intValue).sum() / 5;
            res[index++] = new int[]{entry.getKey(), avg};
        }

        return  res;
    }

    public static void main(String[] args) {
        int[][] items = {
                {1, 91}, {1, 92}, {2, 93}, {2, 97},
                {1, 60}, {2, 77}, {1, 65}, {2, 100},
                {1, 87}, {1, 100}, {2, 100}, {2, 76}
        };

        int[][] res = highFive(items);
        for (int[] arr : res) {
            System.out.println("Student " + arr[0] + " average: " + arr[1]);
        }
    }
}
