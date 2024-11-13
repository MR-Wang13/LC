package neetcode;

public class BinarySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        int row = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] > target){
                right = mid -1;
                row = right;
            }else{
                row = left;
                left = mid + 1;
            }
        }
        if(row<0 || row >= m){
            return false;
        }
        left = 0;
        right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix  = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 61;
        System.out.println(searchMatrix(matrix,target));
    }
}
