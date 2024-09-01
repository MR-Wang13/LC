package lc.top150.dp.one;

public class LC70 {
    int max = 0;
    public int climbStairs(int n) {
        climb(0,1,n,1);
        climb(0,2,n,1);
        return max;
    }

    private void climb(int sum, int step,int n,int steps) {
        sum+=step;
        if (sum>n){
            return;
        }
        if (sum == n ){
            max++;
            return;
        }
        climb(sum,1,n,steps+1);
        climb(sum,2,n,steps+1);
    }

    public static void main(String[] args) {
        LC70 lc = new LC70();
        System.out.println(lc.climbStairs(4));
    }
}

