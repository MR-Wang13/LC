package courses.project2.floyd;

import courses.project2.FileNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Graph {
    List<Node> nodes;
    int[][] distance;
    int[][] next;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Node source, Node destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        source.edges.add(edge);
    }

    public void floydWarshall() {
        int n = nodes.size();
        distance = new int[n][n];
        next = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
                next[i][j] = -1;
            }
        }

        for (Node node : nodes) {
            int u = nodes.indexOf(node);
            for (Edge edge : node.edges) {
                int v = nodes.indexOf(edge.destination);
                distance[u][v] = edge.weight;
                next[u][v] = v;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE &&
                            distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public List<Node> getShortestPath(Node source, Node destination) {
        int u = nodes.indexOf(source);
        int v = nodes.indexOf(destination);
        if (next[u][v] == -1) {
            return null; // 没有路径
        }

        List<Node> path = new ArrayList<>();
        path.add(source);

        while (u != v) {
            u = next[u][v];
            path.add(nodes.get(u));
        }

        return path;
    }
}

public class FloydLinkedList {
    public static void main(String[] args) {
        Graph graph ;
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


                            graph = new Graph();


                            int i = 0;
                            List<Node> nodeList = new ArrayList<>();
                            for (FileNode node : nodes){
                                Node node1 = new Node(i);
                                graph.addNode(node1);
                                nodeList.add(node1);
                                i++;
                            }
                            for (FileNode node : nodes){
                                graph.addEdge(nodeList.get(node.nodeId),nodeList.get(node.connectedNodeID),node.distance);
                            }
                            Long startTime =  System.currentTimeMillis();
                            graph.floydWarshall();
                            Runtime runtime = Runtime.getRuntime();
                            long totalMemory = runtime.totalMemory();
                            long freeMemory = runtime.freeMemory();
                            long usedMemory = totalMemory - freeMemory;

                            Long endTime =  System.currentTimeMillis();

                            System.out.println(file.getName());
                            System.out.println(endTime-startTime+"ms");
                            System.out.println("memory usage:"+usedMemory+"");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}


class Node {
    int data;
    List<Edge> edges;

    Node(int data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }
}

class Edge {
    Node source;
    Node destination;
    int weight;

    Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

