package ng.ziprecruiter;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int level = n/2 + (n%2);
        int round = 1;
        while (round<=level){
            for (int i = round-1; i<n-round;i++){
                int top = matrix[round-1][i];
                int right = matrix[i][n-round];
                int bottom = matrix[n-round][n-i-1];
                int left = matrix[n-i-1][round-1];

                int temp = top;
                matrix[round-1][i] = left;
                matrix[n-i-1][round-1] = bottom;
                matrix[n-round][n-i-1] = right;
                matrix[i][n-round] = temp;
            }
            round++;
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][]  matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
    }
}
