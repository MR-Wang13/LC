package courses.homework2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FloydWarshallWithPath {
    public static void main(String[] args) throws Exception {

        int[][] graph ;
        String folderPath = "/Users/wys/Desktop/2591Algo/Project2/Project2_Input_File";

        File folder = new File(folderPath);

        // 检查文件夹是否存在
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()&&file.getName().contains("_File4")) {
                        // 在这里处理每个文件
                        System.out.println("File Name: " + file.getName());
                        try (BufferedReader br = new BufferedReader(new FileReader(file)) ) {
                            String line;
                            int lines = 0;
                            List<Node> nodes = new ArrayList<>();
                            while ((line = br.readLine()) != null) {
                                if (lines > 0) {
                                    // 使用逗号分隔符将每一行分割为字段
                                    String[] fields = line.split(",");
                                    Node node  = new Node();
                                    node.nodeId = Integer.valueOf(fields[0]);
                                    node.connectedNodeID = Integer.valueOf(fields[1]);
                                    node.distance = Integer.valueOf(fields[2]);
                                    node.coordinates = fields[3];
                                    node.intersectionName = fields[4];
                                    nodes.add(node);

                                }
                                lines++;
                            }
                            int maxNode = nodes.stream().max((s1,s2)->Integer.compare(s1.nodeId,s2.nodeId)).get().nodeId;
                            graph = new int[maxNode+1][maxNode+1];

                            for (Node node : nodes){
                                graph[node.nodeId][node.connectedNodeID] = node.distance;
                            }

                            for (int i =0 ; i<graph.length; i++)
                                for (int j = 0; j<graph.length; j++){
                                    if (graph[i][j]==0){
                                        graph[i][j] = Integer.MAX_VALUE;
                                    }
                                }

                            int[][] shortestDistances;
                            int[][] predecessors;
                            graph = new int[][]{
                                    {0, 6, Integer.MAX_VALUE, 1},
                                    {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                                    {Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE},
                                    {Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0}
                            };
                            FloydWarshallResult result = floydWarshallWithPath(graph);
                            shortestDistances = result.shortestDistances;
                            predecessors = result.predecessors;

                            printMatrix(predecessors);
                            int source = 0;
                            int destination = 1;
                            printShortestPath(shortestDistances,predecessors, source, destination);
                            System.out.println(file.getName()+"---end");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        /*

        int[][] graph = {
                {0, 4, Integer.MAX_VALUE,Integer.MAX_VALUE},
                {3, 0,Integer.MAX_VALUE,18},
                {Integer.MAX_VALUE, 6,0,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,5,15,0}
        };


        */

    }
    public static void printShortestPath(int[][] shortestDistances ,int[][] pred, int source, int destination) {
        if (source == destination) {
            System.out.println(source);
            return;
        }

        if (pred[source][destination] == -1) {
            System.out.println("No path exists.");
            return;
        }

        List<Integer> path = new ArrayList<>();
        path.add(destination);
        System.out.println("Distance: "+shortestDistances[destination][source]+" feet");

        while (source != destination) {
            destination = pred[source][destination];
            path.add(destination);
        }

        Collections.reverse(path);

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    public static FloydWarshallResult floydWarshallWithPath(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];
        int[][] pred = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (i == j || graph[i][j] == Integer.MAX_VALUE) {
                    pred[i][j] = -1;
                } else {
                    pred[i][j] = i;
                }
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j];
                    }
                }
            }
        }

        return new FloydWarshallResult(dist, pred);
    }

    public static void printMatrix(int[][] matrix) {
        int V = matrix.length;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }


}

class FloydWarshallResult {
    int[][] shortestDistances;
    int[][] predecessors;

    FloydWarshallResult(int[][] shortestDistances, int[][] predecessors) {
        this.shortestDistances = shortestDistances;
        this.predecessors = predecessors;
    }
}

