package lc.top150.graph;

public class LC200 {
    int count = 0;
    public int numIslands(char[][] grid) {
        count = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        countIsland(grid,visited);
        return count;
    }

    private void countIsland(char[][] grid, int[][] visited) {
        for (int i = 0 ; i<grid.length ; i++){
            for (int j = 0 ; j<grid[0].length; j++){
                if (grid[i][j]=='1' && visited[i][j]==0){
                    count++;
                    checkIfIsland(grid,i,j,visited);
                }
            }
        }
    }

    private void checkIfIsland(char[][] grid, int i, int j, int[][] visited) {
        if (i<0||i>=grid.length || j<0 || j>=grid[0].length||visited[i][j]==1||grid[i][j]=='0'){
            return;
        }
        visited[i][j] = 1;
        //up
        checkIfIsland(grid,i-1,j,visited);
        //down
        checkIfIsland(grid,i+1,j,visited);
        //left
        checkIfIsland(grid,i,j-1,visited);
        //right
        checkIfIsland(grid,i,j+1,visited);
    }

    public static void main(String[] args) {
        LC200 lc = new LC200();
        char[][] grid = {
    {'1','1','0','0','0'},
    {'1','1','0','0','0'},
    {'0','0','1','0','0'},
    {'0','0','0','1','1'}

};
        System.out.println(lc.numIslands(grid));
    }
}
