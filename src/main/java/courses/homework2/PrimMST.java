package courses.homework2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimMST {
    public static void main(String[] args) {
        int[][] graph = {
                {0,32,0,17,0,0,0,0,0,0},
                {32,0,0,0,45,0,0,0,0,0},
                {0,0,0,18,0,0,5,0,0,0},
                {17,0,18,0,10,0,0,3,0,0},
                {0,45,0,10,0,28,0,0,25,0},
                {0,0,0,0,28,0,0,0,0,6},
                {0,0,5,0,0,0,0,59,0,0},
                {0,0,0,3,0,0,59,0,4,0},
                {0,0,0,0,25,0,0,4,0,12},
                {0,0,0,0,0,6,0,0,12,0}
        };

        List<Edge> mst = primMST(graph);
        printMST(mst);
    }

    static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static List<Edge> primMST(int[][] graph) {
        int V = graph.length;
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);

        List<Edge> mst = new ArrayList<>();
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, inMST);
            inMST[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        for (int i = 1; i < V; i++) {
            mst.add(new Edge(parent[i], i, graph[i][parent[i]]));
        }

        return mst;
    }

    public static int minKey(int[] key, boolean[] inMST) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public static void printMST(List<Edge> mst) {
        System.out.println("Edge   Weight");
        for (Edge edge : mst) {
            System.out.println(edge.u + " - " + edge.v + "    " + edge.weight);
        }
    }
}


