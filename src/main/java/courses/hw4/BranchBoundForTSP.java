package courses.hw4;

import java.util.Arrays;
import java.util.PriorityQueue;
public class BranchBoundForTSP {

        static class Node implements Comparable<Node> {
            int city;
            int level;
            int[] path;
            double cost;

            Node(int city, int level, int[] path, double cost) {
                this.city = city;
                this.level = level;
                this.path = path;
                this.cost = cost;
            }

            @Override
            public int compareTo(Node other) {
                return Double.compare(this.cost, other.cost);
            }
        }

        static int tsp(int[][] graph) {
            int n = graph.length;
            int[] path = new int[n];
            Arrays.fill(path, -1);
            PriorityQueue<Node> pq = new PriorityQueue<>();
            double[][] bound = new double[n][n];

            for (int i = 0; i < n; i++) {
                bound[i][0] = Double.MAX_VALUE;
            }

            double minCost = Double.MAX_VALUE;

            Node rootNode = new Node(0, 0, path, 0);
            rootNode.path[0] = 0;
            pq.add(rootNode);

            while (!pq.isEmpty()) {
                Node currentNode = pq.poll();
                int currentCity = currentNode.city;
                int currentLevel = currentNode.level;

                if (currentLevel == n - 1 && graph[currentCity][0] != 0) {
                    double currentCost = currentNode.cost + graph[currentCity][0];
                    if (currentCost < minCost) {
                        minCost = currentCost;
                        path = currentNode.path;
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        if (graph[currentCity][i] != 0 && !contains(path, i)) {
                            int[] newPath = Arrays.copyOf(currentNode.path, n);
                            newPath[currentLevel + 1] = i;

                            double currentCost = currentNode.cost + graph[currentCity][i];

                            // Calculate lower bound
                            bound[currentCity][i] = currentCost + calculateBound(graph, currentCity, i, n);

                            if (bound[currentCity][i] < minCost) {
                                Node newNode = new Node(i, currentLevel + 1, newPath, currentCost);
                                pq.add(newNode);
                            }
                        }
                    }
                }
            }

            // Print the path and return the minimum cost
            //printPath(path);
            return (int) minCost;
        }

        static double calculateBound(int[][] graph, int currentCity, int nextCity, int n) {
            double bound = 0;
            for (int i = 0; i < n; i++) {
                if (i != currentCity && i != nextCity) {
                    int min = Integer.MAX_VALUE;
                    for (int j = 0; j < n; j++) {
                        if (j != i && j != currentCity && graph[i][j] < min) {
                            min = graph[i][j];
                        }
                    }
                    bound += min;
                }
            }
            return bound;
        }

        static boolean contains(int[] path, int city) {
            for (int i : path) {
                if (i == city) {
                    return true;
                }
            }
            return false;
        }

        static void printPath(int[] path) {
            System.out.println("Optimal Tour Path:");
            for (int city : path) {
                System.out.print(city + " -> ");
            }
            System.out.println("0"); // Return to starting city
        }

        public static void main(String[] args) {
            int[][] graph = {
                    {0, 5, 8, 0, 0, 0, 0, 0},
                    {0, 0, 4, 0, 4, 0, 0, 0},
                    {0, 0, 0, 2, 0, 0, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 7},
                    {1, 0, 0, 0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 2, 0, 0, 0},
                    {0, 0, 0, 3, 0, 8, 0, 0},
                    {0, 0, 0, 0, 0, 5, 4, 0}

            };

            int minCost = tsp(graph);
            System.out.println("Minimum Cost: " + minCost);
        }


}
