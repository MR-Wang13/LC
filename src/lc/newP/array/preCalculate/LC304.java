package lc.newP.array.preCalculate;

public class LC304 {
    int[][] pre ;
    public LC304(int[][] matrix) {
        pre = new int[matrix.length+1][matrix[0].length+1];
        for (int i =0 ; i<matrix.length ; i++)
            for (int j = 0 ; j<matrix[0].length; j++){
                pre[i+1][j+1] = pre[i][j+1]+pre[i+1][j] + matrix[i][j]-pre[i][j];
            }

        System.out.println(pre);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pre[row2+1][col2+1]-pre[row1][col2+1]-pre[row2+1][col1]+pre[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        LC304 lc = new LC304(matrix);
        System.out.println(lc.sumRegion(1,1,2,2));

    }
}
