package ng.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BalancedShipment {
    public static int findMaxBalancedShipments(int[] weights) {
        int n = weights.length;
        int maxBalancedShipments = 0;
        int max  = weights[0]+1;
        for (int i =0 ; i<n;i++){
            for (int j = i; j<n;j++){
                if (weights[j]<max){
                    maxBalancedShipments++;
                }
                max = Math.max(max,weights[j]);
            }
        }

        return maxBalancedShipments;
    }
    public static void main(String[] args) {
        // 测试例子
        int[] weights = {3, 9, 4, 7};
        System.out.println(findMaxBalancedShipments(weights));  // 输出应为 5
    }
}
