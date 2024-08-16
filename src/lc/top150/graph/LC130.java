package lc.top150.graph;

public class LC130 {
    public void solve(char[][] board) {
        int m = board.length,n = board[0].length;
        //边界上的O 和与之相连的 0 都不会被包围
        for (int i = 0 ; i<m ;i++){
           captureO(i,0,m,n,board);
           captureO(i,n-1,m,n,board);
        }
        for (int i = 0 ; i<n ;i++){
            captureO(0,i,m,n,board);
            captureO(m-1,i,m,n,board);
        }

        for (int i = 0 ; i<m ;i++){
            for (int j = 0 ; j<n ; j++){
                if (board[i][j] != 'A'){
                    board[i][j] = 'X';
                }else {
                    board[i][j] = 'O';
                }
            }
        }

        System.out.println(board);
    }

    private void captureO(int i, int j, int m, int n, char[][] board) {
        if (i<0 || i>=m || j<0|| j>=n||board[i][j]!='O'){
            return;
        }
        board[i][j] = 'A';
        captureO(i-1, j, m, n, board);
        captureO(i+1, j, m, n, board);
        captureO(i, j-1, m, n, board);
        captureO(i, j+1, m, n, board);


    }

    public static void main(String[] args) {
        LC130 lc = new LC130();
        char[][] board = {{'O','O'},{'O','O'}};
        lc.solve(board);
    }
}
