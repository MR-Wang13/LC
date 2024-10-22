package ng.tiktok.vo;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public  static  List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int numOfCircles = Math.min(m,n)/2 +1;
        int top = 0, right = n-1, bot = m-1,left = 0;
        List<Integer> result = new ArrayList<>();
        while (numOfCircles-->=1){

            // top
            if(right>=left && top<=bot) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }
            //right
            if(right>=left && top<=bot) {
                for (int i = top; i <= bot; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            // bot
            if(right>=left && top<=bot) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bot][i]);
                }
                bot--;
            }

            // left
            if(right>=left && top<=bot) {
                for (int i = bot; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                {5,6,7,8},{9,10,11,12}};
        spiralOrder(matrix);
    }
}
