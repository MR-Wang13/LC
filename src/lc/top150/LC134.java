package lc.top150;

public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i =0 ; i<gas.length;i++){
            sum+=gas[i]-cost[i];
        }
        if (sum<0){
            return -1;
        }
        int index = -1;
        int tank = 0;
        for (int i =0;i<gas.length;i++){
            tank+=gas[i]-cost[i];
            if (tank<0){
                index = i+1;
                tank = 0;
            }
        }
        return index;
    }



    public static void main(String[] args) {
        LC134 lc = new LC134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(lc.canCompleteCircuit(gas,cost));
    }
}
