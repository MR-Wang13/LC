package courses.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonteCarloNQueensStateSpaceEstimation {
    public static void main(String[] args) {
        int numExperiments = 20; // Number of Monte Carlo experiments
        int n = 8; // Maximum board size to test
        Random random = new Random();


        int totalNodesExplored = 0;
        List<Integer> everyTryNodes = new ArrayList<>();
        for (int i = 0; i < numExperiments; i++) {
            int nodes =  exploreRandomNQueensStateSpace(n, random);
            everyTryNodes.add(nodes);
            totalNodesExplored += nodes;
        }
        double averageNodesExplored = (double) totalNodesExplored / numExperiments;
        System.out.println("Board Size " + n + " - Average Nodes Explored: " + averageNodesExplored);

    }

    private static int exploreRandomNQueensStateSpace(int n, Random random) {
        int[] queens = new int[n];
        return exploreStateSpace(0, n, queens, random);
    }

    private static int exploreStateSpace(int row, int n, int[] queens, Random random) {
        if (row == n) {
            return 1; // A solution is reached, one node explored
        }

        int nodesExplored = 1; // Initialize with 1 for the current node

        int[] columns = new int[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int randomIndex = i + random.nextInt(n - i);
            int col = columns[randomIndex];
            columns[randomIndex] = columns[i];

            if (isSafe(queens, row, col)) {
                queens[row] = col;
                nodesExplored += exploreStateSpace(row + 1, n, queens, random);
            }
        }

        return nodesExplored;
    }

    private static boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
