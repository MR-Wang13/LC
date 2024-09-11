package ng.amazon;

import java.util.*;

public class ServerQuery {
    public static List<Integer> processQueries(int n, int[] queries) {
        // 最小堆，按请求数和服务器ID排序
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 初始化每个服务器的请求数为0
        int[] requests = new int[n];
        for (int i = 0; i < n; i++) {
            heap.offer(new int[]{0, i});  // [请求数, 服务器ID]
        }

        // 存储结果的列表
        List<Integer> result = new ArrayList<>();

        // 遍历每个查询
        for (int query : queries) {
            List<int[]> temp = new ArrayList<>();
            int[] selectedServer = null;

            // 找到最小请求数的服务器，且该服务器ID在 [0, query] 范围内
            while (!heap.isEmpty()) {
                int[] server = heap.poll();
                if (server[1] <= query) {
                    selectedServer = server;  // 选择该服务器
                    break;
                } else {
                    temp.add(server);  // 该服务器不在范围内，暂存
                }
            }

            // 将不符合条件的服务器重新放回堆中
            for (int[] server : temp) {
                heap.offer(server);
            }

            if (selectedServer != null) {
                // 更新所选服务器的请求数并记录其ID
                selectedServer[0]++;
                requests[selectedServer[1]]++;
                result.add(selectedServer[1]);

                // 将更新后的服务器重新放入堆中
                heap.offer(selectedServer);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 3;  // 3个服务器
        int[] queries = {0, 1, 2, 2, 1};  // 查询数组

        List<Integer> result = processQueries(n, queries);
        System.out.println(result);  // 输出服务器ID选择
    }
}
