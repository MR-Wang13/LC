package lc;
import java.util.*;

public class GravityPuzzle {
    private static final int[] directions = {-1, 0, 1, 0, -1};

    public static int minObstaclesToRemove(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        List<int[]> figure = new ArrayList<>();
        int[] init = new int[cols];
        int[] after = new int[cols];
        Arrays.fill(init,-1);
        Arrays.fill(after,-1);
        int close = 0;
        // Find the figure and mark its positions
        for (int c = 0; c <cols; c++) {
                for (int r = rows-1; r >=0; r--) {
                    if (board[r][c] == '*') {
                    init[c] = r;
                    close = Math.max(r,close);
                    break;
                }
            }
        }

        int finalClose = close;
        after = Arrays.stream(init)
                .map(num -> {
                  if (num!=-1) {
                      return num + (rows-(finalClose +1));
                  }else {
                      return num;
                  }
                })
                .toArray();

        return 1;

    }


    public static void main(String[] args) {
        char[][] board = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', '*', '*', '*', '#', '#', '#'},
                {'#', '#', '*', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', '*', '*', '*', '#', '#', '#'},
                {'#', '#', '*', '#', '#', '#', '#'}
        };
        System.out.println(minObstaclesToRemove(board)); // Output should be 0
    }
}

