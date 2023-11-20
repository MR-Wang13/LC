package intern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeaBattleGame {
    private static final int N = 5;
    private boolean[][] visited = new boolean[N][N];

    public List<String> processShots(String[][] game_grid, int[][] shots) {
        List<String> results = new ArrayList<>();

        for (int[] shot : shots) {
            int row = shot[0];
            int col = shot[1];
            String cellValue = game_grid[row][col];

            if (cellValue.isEmpty()) {
                results.add("Missed");
            } else if (visited[row][col]) {
                results.add("Already attacked");
            } else {
                visited[row][col] = true;
                int shipCells = dfs(game_grid, row, col, cellValue);

                if (shipCells == 0) {
                    results.add("Ship " + cellValue + " sunk");
                } else {
                    results.add("Attacked ship " + cellValue);
                }
            }
        }

        return results;
    }

    private int dfs(String[][] grid, int x, int y, String shipType) {
        if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || !grid[x][y].equals(shipType)) {
            return 0;
        }

        visited[x][y] = true;

        // Navigate in all 4 directions
        int count = 1;
        count += dfs(grid, x + 1, y, shipType);
        count += dfs(grid, x - 1, y, shipType);
        count += dfs(grid, x, y + 1, shipType);
        count += dfs(grid, x, y - 1, shipType);

        return count - 1; // -1 because we are interested in unvisited parts of the ship
    }
    static int getExponent(int num){
        int count =0;
        while(num>=10){
            count++;
            num = num %10;
        }
        return count;
    }
    public static void main(String[] args) {
        String[][] grid = {
                {".","A","B","B","B"},
                {".","A",".",".","C"},
                {".",".",".",".","."},
                {"D","D",".",".","."}

        };

        int[][] shots = {
                {0,0},{0,1},{0,2},{1,1},{0,1},
                {1,4},{2,2},{2,4},{0,3},{0,0},{0,4}
        };
        System.out.println(getExponent(1));


    }
}
