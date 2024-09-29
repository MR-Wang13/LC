package courses.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonteCarloForNQueens {
    static int n = 8;


    private  static  int solveNQueens() {
        Random random = new Random();
        int[] queens = new int[n];
        List<Integer> promChildren ;
        int i = -1 ,numNodes = 1,m=1,mProd = 1;
        while (m!= 0 && i!=n-1) {
            mProd = mProd*m;
            numNodes += mProd*n;
            i++;
            m=0;
            promChildren = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                queens[i] = j;
                if (promising(queens, i)) {
                    m++;
                    promChildren.add(j);
                }
            }
            if (m!=0){
                int ranNum = random.nextInt(promChildren.size());
                int node = promChildren.get(ranNum);
                queens[i] = node;
            }
        }
        return numNodes;
    }

    private static boolean promising(int[] queens, int i) {
        for (int k = 0; k < i; k++) {
            if (queens[k] == queens[i] || Math.abs(queens[i] - queens[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int times = 20;
        int totalNums = 0;
        for (int i = 0 ; i<times; i++){
            totalNums +=solveNQueens();
        }
        System.out.println("average of 20 estimates: " +totalNums/times);
    }
}
