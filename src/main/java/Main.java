import java.util.HashMap;
import java.util.Set;

import java.util.*;
public class Main{
    static int[][] grid = new int[3][3];
    static boolean[] usedNum = new boolean[10];
    static List<int[]> emptyPos = new ArrayList<>();
    static int totalWays = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 0; testCase < T; testCase++){
            grid = new int[3][3];
            usedNum = new boolean[10];
            emptyPos = new ArrayList<>();
            boolean isValid = true;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    int num = sc.nextInt();
                    grid[i][j] = num;
                    if(num!=0){
                        if(usedNum[num]){
                            isValid = false;
                        }else{
                            usedNum[num] = true;
                        }
                    }else{
                        emptyPos.add(new int[]{i,j});
                    }
                }
            }
            if(!isValid){
                System.out.println(0);
                continue;
            }
            if(!checkInitailGrid()){
                System.out.println(0);
                continue;
            }
            if(emptyPos.size() == 0){
                System.out.println(1);
                continue;
            }
            totalWays = 0;
            dfs(0);
            System.out.println(totalWays);
        }
    }
    static void dfs(int k){
        if(k == emptyPos.size()){
            totalWays++;
            return;
        }
        int[] pos = emptyPos.get(k);
        int i = pos[0];
        int j = pos[1];
        for(int num =1; num<=9; num++){
            if(!usedNum[num]){
                if(!isValidNum(i,j,num)){
                    grid[i][j] = num;
                    usedNum[num] = true;
                    dfs(k+1);
                    usedNum[num] = false;
                    grid[i][j] = 0;
                }
            }
        }
    }
    static boolean isValidNum(int i, int j, int num){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int dir = 0; dir<4; dir++){
            int ni = i+dx[dir];
            int nj = j+dy[dir];
            if(ni>=0 && ni<3 && nj>=0 && nj<3){
                if(grid[ni][nj]!=0){
                    if(Math.abs(num - grid[ni][nj])==1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean checkInitailGrid(){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j]!=0){
                    for(int dir = 0; dir<4; dir++){
                        int ni = i+dx[dir];
                        int nj = j+dy[dir];
                        if(ni>=0 && ni<3 && nj>=0 && nj<3){
                            if(grid[ni][nj]!=0){
                                if(Math.abs(grid[i][j] - grid[ni][nj])==1){
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }




















}