package ng.ziprecruiter;

import java.util.HashSet;

public class CrossNumber {
    public static int countNearlyRegularCrosses(int[][] matrix) {
       int m = matrix.length,n = matrix[0].length,count = 0;
       for (int i =0 ; i<m ; i++ ){
           for (int j =0 ; j<n;j++){
               if (isRegular(i,j,matrix)){
                   System.out.println(i+" - "+j);
                   count++;
               }

           }
       }
       return count;

    }

    private static boolean isRegular(int i, int j, int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        HashSet<Integer> set = new HashSet<>();
        int left=j-1,right=j+1,top=i-1,bot=i+1;
        while(left>=0||right<n||top>=0||bot<m){
            if (left>=0){
                set.add(matrix[i][left]);
            }
            if (right<n){
                set.add(matrix[i][right]);
            }
            if (top>=0){
                set.add(matrix[top][j]);
            }
            if (bot<m){
                set.add(matrix[bot][j]);
            }
            if (set.size()>1){
                return false;
            }
            left--;right++;top--;bot++;
        }
        return true;
    }

    // 检查以 (i, j) 为交叉点的十字架是否是规则的或几乎规则的
    private static boolean isNearlyRegular(int[][] matrix, int row, int col) {
        int value = matrix[row][col];

        // 检查第 row 行的元素，除了交点
        for (int c = 0; c < matrix[0].length; c++) {
            if (c != col && matrix[row][c] != value) {
                return false;
            }
        }

        // 检查第 col 列的元素，除了交点
        for (int r = 0; r < matrix.length; r++) {
            if (r != row && matrix[r][col] != value) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {2, 3, 1, 2, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 4, 1}
        };

        System.out.println(countNearlyRegularCrosses(matrix));  // 输出应该是 7
    }
}
