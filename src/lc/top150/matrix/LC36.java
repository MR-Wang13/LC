package lc.top150.matrix;

public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[][][] check = new int[3][n][n+1];
        int[][][] checkBox = new int[3][3][n+1];

        for (int i = 0; i < n ; i++ ){
            for (int j = 0;j<n;j++){
                if (board[i][j]!='.'){
                    if (check[0][i][Character.getNumericValue(board[i][j])]==1){
                        return false;
                    }else {
                        check[0][i][Character.getNumericValue(board[i][j])]=1;
                    }
                    if (checkBox[i/3][j/3][Character.getNumericValue(board[i][j])]==1){
                        return false;
                    }else {
                        checkBox[i/3][j/3][Character.getNumericValue(board[i][j])]=1;
                    }
                }

                if (board[j][i]!='.'){
                    if (check[1][i][Character.getNumericValue(board[j][i])]==1){
                        return false;
                    }else {
                        check[1][i][Character.getNumericValue(board[j][i])]=1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC36 lc = new LC36();
        char[][] board =
                        {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','8','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(lc.isValidSudoku(board));
    }
}
