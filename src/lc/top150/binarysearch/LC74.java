package lc.top150.binarysearch;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top =0 ,left = 0 ,bot= m-1,right = n;
        while (top<=bot){
            int mid = top + (bot-top)/2;
            if (matrix[mid][0] <= target && matrix[mid][n-1]>=target){
                while (left<=right){
                    int mid2 = left+ (right-left)/2;
                    if (matrix[mid][mid2]==target){
                        return true;
                    }else if(matrix[mid][mid2]>target){
                        right = mid2-1;
                    }else {
                        left = mid2+1;
                    }
                }
                return false;
            }else if(matrix[mid][0]>target){
                bot = mid-1;
            }else if(matrix[mid][n-1]<target){
                top = mid +1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        LC74 lc = new LC74();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(lc.searchMatrix(matrix,3));
    }
}
