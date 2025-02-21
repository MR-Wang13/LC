package neetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Heapp {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(Arrays.stream(stones).boxed().toList());

        while (queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            if(a - b != 0) {
                queue.add(a - b);
            }
        }
        return queue.size()!=0?queue.poll():0;
    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(
                Pair::compare
        );
        for(int[] point : points){
            queue.add(new Pair(point[0], point[1]));
        }
        int[][] result = new int[k][2];
        int index=0;
        while (!queue.isEmpty()){
            if(index >= k){
                break;
            }
            Pair p = queue.poll();
            result[index][0] = p.x;
            result[index++][1] = p.y;
        }


        return result;
    }
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        int compare(Pair a){
            return Integer.compare(x*x + y*y,a.x*a.x+a.y*a.y);
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks){
            count[c - 'A']++;
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int cnt : count){
            if(cnt > 0) {
                pq.offer(cnt);
            }
        }

        Queue<int[]> queue  = new ArrayDeque<>();

        int times = 0;
        while(!pq.isEmpty() || ! queue.isEmpty()){
            times++;
            if(!pq.isEmpty()) {
                int cnt = pq.poll() - 1;
                if (cnt > 0) {
                    queue.add(new int[]{cnt, times + n});
                }
            }

            if(!queue.isEmpty() && queue.peek()[1] == times){
                pq.offer(queue.poll()[0]);
            }
        }
        return times;
    }
    public static void main(String[] args) {
       /* int[] stones={2,3,6,2,4};
        //lastStoneWeight(stones);
        int[][] points = {{3,3},{-2,4},{5,-1}};
        int k = 2;
        kClosest(points,k);*/
        char[] tasks = {'X','X','Y','Y'};
        int n = 2;
        System.out.println(leastInterval(tasks,n));
    }
}
