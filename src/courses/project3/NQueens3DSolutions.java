package courses.project3;
public class NQueens3DSolutions {

    private static  int N = 5; // Change to 8 for n=8
    private static final int[][][] board = new int[N][N][N];

    private static int count = 0;
    public static void main(String[] args) {
        int[] trys = {2,3,4,5};
        for (int n : trys) {
            N =n;
            solveNQueens3D(0);
            System.out.println("n = " + N + " solution: " + count);
            count=0;
        }
    }

    static void solveNQueens3D(int level) {
        if (level == N) {
            count++;
            return ;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (promising(level, i, j)) {
                    board[level][i][j] = 1;
                    solveNQueens3D(level + 1);
                    board[level][i][j] = 0;
                }
            }
        }
    }

    static boolean promising(int level, int row, int col) {

        // Check cross level diagonals
        for (int k = 0; k < level; k++) {

            // Check every col and row
            for (int i = 0; i < N; i++)
                if (board[k][row][i] == 1 ||board[k][i][col] ==1)
                    return false;
            // Check upper diagonal
            for ( int i = row, j = col; i >= 0 && j >= 0; i--, j--)
                if (board[k][i][j] == 1)
                    return false;
            for ( int i = row, j = col; i <N && j < N; i++, j++)
                if (board[k][i][j] == 1)
                    return false;

            // Check lower diagonal
            for ( int i = row, j = col; j >= 0 && i < N; i++, j--)
                if (board[k][i][j] == 1)
                    return false;

            for ( int i = row, j = col; i >= 0 && j < N; i--, j++)
                if (board[k][i][j] == 1)
                    return false;

        }

        return true;
    }


    static void printBoard() {
        for (int k = 0; k < N; k++) {
            System.out.println("Level " + k + ":");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[k][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
