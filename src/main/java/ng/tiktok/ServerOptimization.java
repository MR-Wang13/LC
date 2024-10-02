package ng.tiktok;

import java.util.*;

public class ServerOptimization {
    public static int goodNumberServer(int n,int[][] disconnectedPair){
        // (n-1)n/2
        HashSet<Integer> disconnectedNode = new HashSet<>();
        for(int[] pair : disconnectedPair){
            disconnectedNode.add(pair[0]);
            disconnectedNode.add(pair[1]);
        }
        int total= n;
        for(int i  = 0 ; i<n;i++){
            int right = i;
            int count = 0;
            while ( right<n){
                if (!disconnectedNode.contains(right)){
                    count++;
                    right++;
                }

                while (disconnectedNode.contains(right)){
                    right++;
                }
            }
            total+=count;
        }
        return total;


    }
    public static long optimizeTikTokRoutes(int numServers, int numDisconnectedPairs, List<List<Integer>> disconnectedPairs) {
        // 创建一个数组，记录从每个服务器起始，能延伸到的最远端
        int[] maxReach = new int[numServers + 1];
        Arrays.fill(maxReach, numServers); // 初始化为最大值，即每个服务器默认能连接到最后一个服务器

        // 处理断开的服务器对，更新每个服务器的最远可达位置
        for (List<Integer> pair : disconnectedPairs) {
            int server1 = pair.get(0);
            int server2 = pair.get(1);
            int min = Math.min(server1, server2);
            int max = Math.max(server1, server2);
            // 更新最小编号服务器的最远可达位置
            maxReach[min] = Math.min(maxReach[min], max - 1);
        }

        // 滑动窗口计数“好”的子段
        long goodSubsegments = 0;
        int currentMax = 0; // 当前子段的最远可达位置

        for (int start = 1; start <= numServers; start++) {
            // 更新当前子段的最远可达位置
            currentMax = Math.min(currentMax, maxReach[start]);

            // 计算从start开始到currentMax的所有合法子段
            goodSubsegments += currentMax - start + 1;

            // 更新currentMax为当前的start
            currentMax = Math.max(currentMax, start);
        }

        return goodSubsegments;
    }

    public static void main(String[] args) {
        //System.out.println(goodNumberServer(4,new int[][]{{1,2},{2,3}}));
        int numServers = 4;
        int numDisconnectedPairs = 2;
        List<List<Integer>> disconnectedPairs = List.of(
                List.of(1, 2),
                List.of(2, 3)
        );

        long result = optimizeTikTokRoutes(numServers, numDisconnectedPairs, disconnectedPairs);
        System.out.println(result);
    }
}
