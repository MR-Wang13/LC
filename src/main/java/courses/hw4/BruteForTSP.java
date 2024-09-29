package courses.hw4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BruteForTSP {
    private int numberOfCities;
    private int[][] distanceMatrix;
    private boolean[] visited;
    private int minTourCost = Integer.MAX_VALUE;
    private List<Integer> bestTour;

    public BruteForTSP(int numberOfCities, int[][] distanceMatrix) {
        this.numberOfCities = numberOfCities;
        this.distanceMatrix = distanceMatrix;
        this.visited = new boolean[numberOfCities];
        this.bestTour = new ArrayList<>();
    }

    public void solve() {
        List<Integer> tour = new ArrayList<>();
        visited[0] = true;
        tour.add(0);
        permutation(1, tour, 0);
    }

    private void permutation(int pos, List<Integer> tour, int tourCost) {
        if (pos == numberOfCities) {
            if (distanceMatrix[tour.get(pos - 1)][tour.get(0)] > 0) { // Check if return to start city is possible
                int totalTourCost = tourCost + distanceMatrix[tour.get(pos - 1)][tour.get(0)];
                if (totalTourCost < minTourCost) {
                    minTourCost = totalTourCost;
                    bestTour.clear();
                    bestTour.addAll(tour);
                }
            }
            return;
        }

        for (int i = 0; i < numberOfCities; i++) {
            if (!visited[i] && distanceMatrix[tour.get(pos - 1)][i] > 0) {
                visited[i] = true;
                tour.add(i);
                permutation(pos + 1, tour, tourCost + distanceMatrix[tour.get(pos - 1)][i]);
                visited[i] = false;
                tour.remove(tour.size() - 1);
            }
        }
    }

    public void showResult() {
        System.out.println("Minimum Tour Cost: " + minTourCost);
        System.out.println("Tour: " + bestTour);
    }

    public static void main(String[] args) {
        int[] ns = { 6, 7, 8, 9,
                10, 15, 20};
        for (int num : ns) {
            int n = num;
            int[][] distanceMatrix  = generateMatrix(n);
            long startTime = System.currentTimeMillis();
            BranchBoundForTSP branchBoundForTSP = new BranchBoundForTSP();
            branchBoundForTSP.tsp(distanceMatrix);

            long endTime = System.currentTimeMillis();
            long timeForBranchBound = endTime-startTime;
            startTime = System.currentTimeMillis();

            BruteForTSP tsp = new BruteForTSP(n, distanceMatrix);
            tsp.solve();
            endTime = System.currentTimeMillis();

            long timeForBrute = endTime-startTime;

            System.out.println("n: "+n +", timeForBranchBound: "+timeForBranchBound+", timeForBrute: "+timeForBrute);
        }
    }

    private static int[][] generateMatrix(int n) {
        Random random = new Random();
        int[][] matrix = new int[n][n];
        for (int i = 0; i<matrix.length;i++)
            for (int j = 0; j<matrix[0].length; j++){
                if (i==j){
                    matrix[i][j]=0;
                }else {
                    matrix[i][j] = random.nextInt(n)+1;
                }
            }
        return matrix;
    }
}
