package ng.meta;

public class LC348 {
    static class TicTacToe{
        int n;
        int[][] colCheck;
        int[][] rowCheck;
        int[][] digCheck;
        int pre;
        boolean hasWinner;
        TicTacToe (int n){
            this.n = n;
            this.pre = -1;
            this.hasWinner = false;
            colCheck = new int[2][n];
            rowCheck = new int[2][n];
            digCheck = new int[2][2];
        }
        public int move(int i, int j, int p){
            // illegal case
            if(hasWinner || p == pre){
                return -1;
            }
            pre = p;
            colCheck[p-1][j]++;
            rowCheck[p-1][i]++;
            if (i == j) {
                digCheck[p-1][0]++;
            }
            if(i + j +1 == n){
                digCheck[p-1][1]++;
            }
            if(colCheck[p-1][j] == n ||  rowCheck[p-1][i]== n
                    ||digCheck[p-1][0] == n ||digCheck[p-1][1] == n
            ){
                return p;
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0,0,1));
        System.out.println(toe.move(0,2,1));
        System.out.println(toe.move(1,1,1));
        System.out.println(toe.move(2,0,1));

    }
}
