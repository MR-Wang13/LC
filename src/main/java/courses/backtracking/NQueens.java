package courses.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    int count = 0;
    public void solveNQueens(int n) {
        int[] queens = new int[n];
        solveNQueens(0, n, queens);
        System.out.println(count);
   }

    private void solveNQueens(int row, int n, int[] queens) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (promising(queens, row, col)) {
                queens[row] = col;
                solveNQueens(row + 1, n, queens);
            }
        }
    }

    private boolean promising(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int n = 3;
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(n);
    }
}
