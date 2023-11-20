package courses.project3;
public class NQueens3D {

    private static final int N = 4; // Change to 8 for n=8
    private static final int[][][] board = new int[N][N][N];

    private static int count = 0;
    public static void main(String[] args) {

         if (solveNQueens3D(0)){
             printBoard();
         };

        System.out.println(count);
    }

    static boolean solveNQueens3D(int level) {
        if (level == N) {
            count++;
            return true ;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (promising(level, i, j)) {
                    board[level][i][j] = 1;
                    if(solveNQueens3D(level + 1)){
                        return true;
                    }
                    board[level][i][j] = 0;
                }
            }
        }
        return false;
    }

    static boolean promising(int level, int row, int col) {

        // Check cross level diagonals
        for (int k = 0; k <= level; k++) {

            // Check this row on left side
            for (int i = 0; i < N; i++)
                if (board[k][row][i] == 1 ||board[k][i][col] ==1)
                    return false;
            // Check upper diagonal on left side
            for ( int i = row, j = col; i >= 0 && j >= 0; i--, j--)
                if (board[k][i][j] == 1)
                    return false;

            // Check lower diagonal on left side
            for ( int i = row, j = col; j >= 0 && i < N; i++, j--)
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
