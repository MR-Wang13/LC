package ng.tiktok.vo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC994 {
    public static int orangesRotting(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int max = 0;
        for(int i = 0 ; i<m;i++){
            for(int j = 0;j<n ; j++){
                if(grid[i][j] == 2) {
                    extendRotten(grid, i, j, 0,visited);
                }
            }
        }
        for(int i = 0 ; i<m;i++){
            for(int j = 0;j<n ; j++){
                if( grid[i][j]==1) {
                    max = Math.max(max, visited[i][j]);
                    if (visited[i][j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                }
            }
        }

        return max;
    }

    private static void extendRotten(int[][] grid, int i, int j, int level, int[][] visited) {
        int m = grid.length,n = grid[0].length;
        if(i<0 || i>=m||j<0||j>=n||grid[i][j] == 0){
            return;
        }
        if(level>= visited[i][j]){
            return;
        }
        visited[i][j] = level;
        extendRotten(grid, i+1, j, level+1, visited);
        extendRotten(grid, i-1, j, level+1, visited);
        extendRotten(grid, i, j+1, level+1, visited);
        extendRotten(grid, i, j-1, level+1, visited);


    }
    public static int orangesRottingBFS(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int numOfFreshOranges = 0;
        for(int i = 0 ; i<m;i++){
            for(int j = 0;j<n ; j++){
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    numOfFreshOranges++;
                }
            }
        }
        if(numOfFreshOranges == 0){
            return 0;
        }
        int times = -1,rottenOranges=0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()){
            times++;
            int size = queue.size();
            for(int i = 0 ; i<size;i++){
                int[] indexes = queue.poll();
                for(int[] direction : directions){
                    int indexI = indexes[0]+direction[0];
                    int indexJ = indexes[1]+direction[1];
                    if(indexI<0 || indexI>=m ||indexJ<0 || indexJ>=n){
                        continue;
                    }
                    if(grid[indexI][indexJ] == 1 ){
                        grid[indexI][indexJ] = 2;
                        queue.add(new int[]{indexI,indexJ});
                        rottenOranges++;
                    }
                }
            }
        }
        return rottenOranges != numOfFreshOranges?-1:times;
    }
        public static void main(String[] args) {
        int[][]  grid = {{2,1,1},{0,1,1},{1,0,1}};
            orangesRottingBFS(grid);
    }
}
