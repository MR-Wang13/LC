package ng.gs;


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left<=right && top<=bottom){
            // top
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            //right
            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom) {
                //bottom
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
                //left
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix =
                        {
                                {1,2,3},
                                {5,6,7},
                                {5,6,7},
                        };
        System.out.println(spiralOrder(matrix));
    }
}
