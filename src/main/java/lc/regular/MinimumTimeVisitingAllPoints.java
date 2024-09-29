package lc.regular;

public class MinimumTimeVisitingAllPoints {
    static public int minTimeToVisitAllPoints(int[][] points) {
        int totalSeconds = 0;
        for (int i =0; i< points.length-1; i++){

            int x1 = points[i][0];
            int y1 = points[i][1];

            int x2 = points[i+1][0];
            int y2 = points[i+1][0];

            totalSeconds+= Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
        }
        return totalSeconds;
    }

    public static void main(String[] args) {
        int[][] points = {{3,2},{-2,2}};

        System.out.println(minTimeToVisitAllPoints(points));
    }
}
