package courses.project3;
public class NQueens3DSolutions_1 {

    private static  int N = 5; // Change to 8 for n=8
    private static  int[][][] board = new int[N][N][N];

    private static int count = 0;
    public static void main(String[] args) {
        int[] trys = {3};
        for (int n : trys) {
            N =n;
            board = new int[N][N][N];
            solveNQueens3D(0);
            System.out.println("n = " + N + " solution: " + count);
            count=0;
        }
    }

    static void solveNQueens3D(int level) {
        if (level == N) {
            printBoard();
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
        //check the vertical line
        for (int k = level; k >=0; k--) {

            if (board[k][row][col] == 1)
                return false;
        }

        // Check 90 degree panel line
        for (int k = level,i = row; k >=0&&i>=0; k--,i--) {

            if ( board[k][i][col] == 1)
                    return false;
        }
        for (int k = level,i = row; k >=0&&i<N; k--,i++) {

            if ( board[k][i][col] == 1)
                return false;
        }
        for (int k = level,j = col; k >=0&&j>=0; k--,j--) {

            if ( board[k][row][j] == 1)
                return false;
        }
        for (int k = level,j = col; k >=0&&j<N; k--,j++) {

            if ( board[k][row][j] == 1)
                return false;
        }

        // Check 45 degree panel line
        for (int k = level,i = row, j = col; k >=0&&i >= 0 && j >= 0; k--, i--, j--) {
            if (board[k][i][j] == 1)
                    return false;
        }
        for (int k = level,i = row, j = col; k >=0&&i <N && j < N; k--,i++, j++) {
            if (board[k][i][j] == 1)
                return false;
        }
        for (int k = level,i = row, j = col; k >=0&&j >= 0 && i < N; k--, i++, j--) {
            if (board[k][i][j] == 1)
                return false;
        }

        for (int k = level,i = row, j = col; k >=0&& i >= 0 && j < N; k--, i--, j++) {
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
