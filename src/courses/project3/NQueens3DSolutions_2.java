package courses.project3;
public class NQueens3DSolutions_2 {

    private static  int N = 5; // Change to 8 for n=8
    private static  int[][][] board = new int[N][N][N];

    private static int count = 0;
    public static void main(String[] args) {
        int[] trys = {2,3,4,5};
        for (int n : trys) {
            N =n;
            board = new int[N][N][N];
            solveNQueens3D(0,0,0,0);

            System.out.println("n size: " + N + " All the solution: " + count/factorial(n));
            count=0;
        }
    }
    /**
     * Used to remove duplicates
     *
     * */
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
    static void solveNQueens3D(int sum,int level,int row,int col) {
        if (sum == N) {
            count++;
            return ;
        }

        for (int i = level; i < N; i++) {
            for (int j = row; j < N; j++) {
                for (int k = col;k < N ; k++) {
                    if (promisingMath(i, j, k) && board[i][j][k]==0) {
                        board[i][j][k] = 1;
                        solveNQueens3D(sum + 1, 0, 0,0);
                        board[i][j][k] = 0;
                    }
                }
            }
        }
    }

    static boolean promisingMath(int level, int row, int col) {
        int x,y,z,m;
        for (x =-1 ; x<=1; x++)
            for (y = -1 ; y<=1; y++)
                for (z=-1; z<=1; z++) {
                    if (x==0&&y==0&&z==0){
                        continue;
                    }
                    for (m = 1; m <= N; m++) {

                        int i = level + m * x;
                        int j = row + m * y;
                        int k = col + m * z;

                        if (i >= 0 && i < N && j >= 0 && j < N && k >= 0 && k < N && board[i][j][k] == 1) {
                            return false;
                        }
                    }
                }

        return true;
    }

    static boolean promising2D(int level, int row, int col)
    {
        int i, j;

        // Check this row on left side
        for (i = 0; i < N; i++) {
            if (board[level][i][col] == 1 || board[level][row][i] == 1)
                return false;
        }


        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[level][i][j] == 1)
                return false;


        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[level][i][j] == 1)
                return false;

        return true;
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
