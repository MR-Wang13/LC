package ng.zijie;
import java.util.*;

public class GraphTree {

    public static void main(String[] args) {
        // 测试用例
        int n = 5; // 5个节点
        int m = 6; // 6条边

        // 边的定义 (u, v)
        int[][] edgesInput = {
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
                {3, 4},
                {3, 5}
        };

        List<int[]> edges = new ArrayList<>();
        for (int[] edge : edgesInput) {
            edges.add(edge);
        }

        // 生成树并输出结果
        List<int[]> treeEdges = solution(n, edges);

        for (int[] edge : treeEdges) {
            System.out.println(edge[0] + " " + edge[1]);
        }
    }
    public static List<int[]> solution(int n, List<int[]> edges) {
        List<int[]> tree= new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty() && tree.size() < n-1){
            int node = queue.poll();
            for (int[] edge: edges){
                int v = edge[0];
                int u = edge[1];
                if (v==node && !visited[u]){
                    tree.add(edge);
                    visited[u]=true;
                    queue.add(u);
                }else if (u==node&& !visited[v]){
                    tree.add(edge);
                    visited[u]=true;
                    queue.add(u);
                }
            }
        }
        return tree;
    }
    public static List<int[]> generateTree(int n, List<int[]> edges) {
        boolean[] visited = new boolean[n + 1];
        List<int[]> treeEdges = new ArrayList<>();
        visited[1] = true; // 假设从 1 号点开始
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty() && treeEdges.size() < n - 1) {
            int node = queue.poll();
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                if (u == node && !visited[v]) {
                    visited[v] = true;
                    treeEdges.add(edge);
                    queue.add(v);
                } else if (v == node && !visited[u]) {
                    visited[u] = true;
                    treeEdges.add(edge);
                    queue.add(u);
                }
            }
        }

        return treeEdges;
    }
}

