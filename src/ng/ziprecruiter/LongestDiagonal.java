package ng.ziprecruiter;

public class LongestDiagonal {
    public int solution(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[] patterns = {2,0};
        int[] directions = {-1,1};
        for(int i = 0 ; i<n ; i++){
            for (int j = 0 ; j<m;j++){
                if (matrix[i][j] == 1) {
                    for (int l = 0;l<2;l++){
                        for (int r = 0;r<2;r++){
                            max = Math.max(max, dfs(matrix,i,j,patterns,new int[]{directions[l],directions[r]}));
                        }
                    }

                }
            }
        }
        return max;

    }

    private int dfs(int[][] matrix, int i, int j, int[] patterns, int[] directions) {
        int len = 1;
        int row = i+directions[0],col = j+directions[1];
        int patternIndex = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        while (row<n&&row>=0 && col>=0&&col<m&&matrix[row][col]==patterns[patternIndex]){
            len++;
            row+=directions[0];
            col+=directions[1];
            patternIndex++;
            patternIndex = patternIndex%patterns.length;
        }
        return len;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1, 2}, {0, 2, 2, 2}, {2, 1, 0, 1}};
        LongestDiagonal ld = new LongestDiagonal();
        System.out.println(ld.solution(matrix));
    }
}
