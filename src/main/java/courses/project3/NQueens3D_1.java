package courses.project3;

public class NQueens3D_1 {
    int N = 5;
    int[][][] board = new int[N][N][N];
    int count =0 ;
    void processing(int level){
        if ( level == N ){
            count++;
            return;
        }
        for (int row = 0 ;row<N; row++)
            for (int col = 0; col<N; col++){

            }

    }
}
