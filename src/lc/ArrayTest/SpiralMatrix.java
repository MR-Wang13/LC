package lc.ArrayTest;
/**
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * */
public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int loop = n/2;
        int count = 1;
        int index_x = 0;
        int bound = 1;
        while (loop>0){
            for (int i = index_x; i<n-bound;i++){
                result[index_x][i] = count++;
            }
            for (int j = index_x; j<n-bound; j++){
                result[j][n-index_x-1]=count++;
            }
            for (int k = n-index_x-1 ; k>index_x ;k--){
                result[n-index_x-1][k]=count++;
            }

            for (int h = n-index_x-1 ; h>index_x ;h--){
                result[h][index_x]=count++;
            }
            index_x++;
            bound++;
            loop --;
        }
        if (n%2==1){
            result[n/2][n/2]=count;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix();
        matrix.generateMatrix(4);
    }
}
