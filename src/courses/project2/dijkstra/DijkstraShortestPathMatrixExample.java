package courses.project2.dijkstra;

import courses.project2.FileNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DijkstraMatrixGraph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public DijkstraMatrixGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public void dijkstra(int source, int destination) {
        int[] distance = new int[vertices];
        int[] parent = new int[vertices];
        boolean[] shortestPathTreeSet = new boolean[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(shortestPathTreeSet, false);

        distance[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(distance, shortestPathTreeSet);
            shortestPathTreeSet[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!shortestPathTreeSet[v] && adjacencyMatrix[u][v] != 0 &&
                        distance[u] != Integer.MAX_VALUE && distance[u] + adjacencyMatrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + adjacencyMatrix[u][v];
                    parent[v] = u;
                }
            }
        }

        printShortestPath(source, destination, distance, parent);
    }

    private int minDistance(int[] distance, boolean[] shortestPathTreeSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!shortestPathTreeSet[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void printShortestPath(int source, int destination, int[] distance, int[] parent) {
        if (distance[destination] == Integer.MAX_VALUE) {
            System.out.println("no path from " + source + " to " + destination + " ");
            return;
        }

        System.out.print("shortest path from " + source + " to " + destination + ": ");
        printPath(destination, parent);
        System.out.println(" Distance: " + distance[destination]+" feet");
    }

    private void printPath(int vertex, int[] parent) {
        if (vertex == -1) {
            return;
        }
        printPath(parent[vertex], parent);
        System.out.print(vertex + " ");
    }
}

public class DijkstraShortestPathMatrixExample {
    public static void main(String[] args) {
        String folderPath = "/Users/wys/Desktop/2591Algo/Project2/Project2_Input_File";

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()&&file.getName().contains("_File")) {
                        try (BufferedReader br = new BufferedReader(new FileReader(file)) ) {
                            String line;
                            int lines = 0;
                            List<FileNode> nodes = new ArrayList<>();
                            while ((line = br.readLine()) != null) {
                                if (lines > 0) {
                                    String[] fields = line.split(",");
                                    FileNode node  = new FileNode();
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


                            DijkstraMatrixGraph matrixGraph = new DijkstraMatrixGraph(maxNode+1);

                            for (FileNode node : nodes){
                                matrixGraph.addEdge(node.nodeId,node.connectedNodeID,node.distance);
                            }

                            int source = 192;
                            int destination = 163;

                            Long startTime =  System.currentTimeMillis();

                            matrixGraph.dijkstra(source, destination);

                            Long endTime =  System.currentTimeMillis();

                            System.out.println(file.getName());
                            System.out.println(endTime-startTime+"ms");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
