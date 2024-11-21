package ng.meta;

public class LC48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int times = n % 2 == 0 ? n/2:(n/2) +1;
        int index = 0;
        while(times-->0){
            int transTime =  (n - 1) - 2 * index;
            for(int i = index; i < index+ transTime; i++){
                int first = matrix[index][i];
                int second = matrix[i][n - 1- index];
                int third =  matrix[n - 1- index][n -1- i];
                int fourth =  matrix[n - 1-i][index];
                int temp = matrix[index][i];
                matrix[index][i] = matrix[n - 1-i][index];
                matrix[n - 1-i][index] =  matrix[n - 1- index][n -1- i];
                matrix[n - 1- index][n -1- i] = matrix[i][n - 1- index];
                matrix[i][n - 1- index] = temp;
            }
            index++;
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix =
                        {{5,1,9,11},
                        {2,4,8,10},
                        {13,3,6,7},
                        {15,14,12,16}};
        rotate(matrix);
    }
}
