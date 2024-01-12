package lc.regular;

import java.util.Arrays;
import java.util.HashMap;

public class ForRegular {
    static public int findSpecialInteger(int[] arr) {
        int threshHold = arr.length/4;
        HashMap<Integer,Integer> mapCountTime = new HashMap<>();
        for (int num : arr){
            mapCountTime.put(num,mapCountTime.getOrDefault(num,0)+1);
            if (mapCountTime.get(num)>threshHold){
                return num;
            }
        }
        return 0;
    }
    static public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
    static public int[][] onesMinusZeros(int[][] grid) {
        int[] rowOneNum = new int[grid.length];
        int[] colOneNum = new int[grid[0].length];
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                rowOneNum[i] += grid[i][j];
                colOneNum[j] += grid[i][j];
            }
        }

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                int oneNum  = rowOneNum[i] + colOneNum[j];
                grid[i][j] = 2*oneNum - (grid.length + grid[0].length);
            }
        }

        return grid;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,2};
        int[][] grid = {{0,1,1},{1,0,1},{0,0,1}};
        onesMinusZeros(grid);
        System.out.println(maxProduct(arr));
    }
}
