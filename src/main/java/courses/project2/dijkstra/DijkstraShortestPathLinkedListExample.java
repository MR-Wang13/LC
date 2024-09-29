package courses.project2.dijkstra;

import courses.project2.FileNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Graph {
    List<Node> nodes;

    public Graph() {
        this.nodes = new LinkedList<>();
    }

    public void adNode(Node node) {
        nodes.add(node);
    }

    public void adEdge(Node source, Node destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        source.edges.add(edge);
    }

    public void dijkstra(Node source, Node destination) {
        source.distance = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        queue.add(source);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == destination) {
                break;
            }

            current.visited = true;

            for (Edge edge : current.edges) {
                Node neighbor = edge.destination;
                int tentativeDistance = current.distance + edge.weight;

                if (!neighbor.visited && tentativeDistance < neighbor.distance) {
                    neighbor.distance = tentativeDistance;
                    neighbor.previous = current;
                    queue.add(neighbor);
                }
            }
        }

        printShortestPath(source, destination);
    }

    private void printShortestPath(Node source, Node destination) {
        if (destination.distance == Integer.MAX_VALUE) {
            System.out.println("no path from " + source.data + " to " + destination.data + " ");
            return;
        }

        Node current = destination;
        LinkedList<Node> path = new LinkedList<>();
        int totalDistance = 0;

        while (current != null) {
            path.addFirst(current);
            if (current.previous != null) {
                totalDistance += current.distance - current.previous.distance;
            }
            current = current.previous;
        }

        System.out.print("shortest path from " + source.data + " to " + destination.data + ": ");
        for (Node node : path) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("Distance: " + totalDistance+" feet");
    }
}

public class DijkstraShortestPathLinkedListExample {
    public static void main(String[] args) {

        Graph graph ;
        String folderPath = "/Users/wys/Desktop/2591Algo/Project2/Project2_Input_File";

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()&&file.getName().contains("_File4")) {
                        System.out.println("File Name: " + file.getName());
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
                                graph.adNode(node1);
                                nodeList.add(node1);
                                i++;
                            }
                            for (FileNode node : nodes){
                                graph.adEdge(nodeList.get(node.nodeId),nodeList.get(node.connectedNodeID),node.distance);
                            }


                            System.out.println("DijkstraShortestPathLinkedListExample output : ");

                            Node source = nodeList.get(192);
                            Node destination = nodeList.get(163);
                            graph.dijkstra(source, destination);

                            source = nodeList.get(138);
                            destination = nodeList.get(66);
                            graph.dijkstra(source, destination);

                            source = nodeList.get(465);
                            destination = nodeList.get(22);
                            graph.dijkstra(source, destination);


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
    boolean visited;
    int distance;
    Node previous;

    Node(int data) {
        this.data = data;
        this.edges = new LinkedList<>();
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
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

