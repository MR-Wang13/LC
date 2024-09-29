package lc.top150.matrix;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        int left =0 ,right = col -1 , top = 0, bottom = rows-1,count=0;
        List<Integer> result = new ArrayList<>();

        while (left<=right&&top<=bottom){
            //top
            for (int i = left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            //right
            for (int i = top ; i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;
            if (top<=bottom) {
                //bottom
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left<=right) {
                //left
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC54 lc = new LC54();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(lc.spiralOrder(matrix));
    }
}
