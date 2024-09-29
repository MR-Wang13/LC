package ng.shoppe;

import java.math.BigInteger;



public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param road int整型 一维数组
     * @return int整型
     */
    static   public int MaxCollectedWater(int[] road) {
        // write code here
        int n = road.length;
        int[] leftMaxBound = new int[n+1];
        int[] rightMaxBound = new int[n+1];
        leftMaxBound[0] =0;
        rightMaxBound[n] = 0;
        int maxLeft = 0;
        for(int i =1 ; i<=n ; i++){
            maxLeft = Math.max(maxLeft,road[i-1]);
            leftMaxBound[i] = maxLeft;
        }
        int maxRight=0;
        for(int i =n-2 ; i>=0 ; i--){
            maxRight = Math.max(maxRight,road[i+1]);
            rightMaxBound[i] = maxRight;
        }
        int total = 0;
        for(int i =0;i<n;i++){
            if(Math.min(leftMaxBound[i],rightMaxBound[i])>road[i]){
                total+=Math.min(leftMaxBound[i],rightMaxBound[i])-road[i];
            }
        }
        return total;
    }
     static public long SumOfGreatestOddDivisor(long n) {
        // write code here
        int max=0;
        long temp =n;
        BigInteger total =BigInteger.ZERO;
        while(temp>0){
            temp>>=1;
            max++;
        }
        for(int i = 0; i<max ;i++){
            long t = (n>>i) - (n>>(i+1));
            BigInteger bt = BigInteger.valueOf(t);
            total =total.add(bt.multiply(bt));
        }

        return total.longValue();
    }

    public int FindSpecialUser(int n, int[][] relations) {
        // write code here
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for(int[] relation:relations){
            int follower = relation[0];
            int followed = relation[1];
            outDegree[follower]++;
            inDegree[followed]++;
        }
        for (int user=1;user<=n;user++){
            if(inDegree[user] == n-1 && outDegree[user] ==0){
                return user;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(SumOfGreatestOddDivisor(3));
    }
}

