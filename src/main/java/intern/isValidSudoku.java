package intern;

public class isValidSudoku {
    /**
     *
     * use three array to record the count that the number shown
     * row columns sub box
     *
     * */
    boolean isValid(char[][] board){
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subBox = new int[3][3][9];
        for (int i=0; i<9; i++)
            for (int j=0; j<9; j++){
                char c  = board[i][j];
                if (c!='.'){
                    int index = c-'0'-1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subBox[j/3][i/3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subBox[j / 3][i / 3][index] > 1) {
                        return false;
                    }
                }
            }
        return true;
    }

    public static void main(String[] args) {
        char[][] board  =
                {
                        {'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}
                }
        ;
        isValidSudoku  validSudoku  = new isValidSudoku();
        System.out.println(validSudoku.isValid(board));

    }
}
