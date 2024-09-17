package ng.ziprecruiter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class HouseSegment {
    public int[] solution(int[] queries) {
        TreeSet<Integer> houses = new TreeSet<>();  // 用于存储已经建好的房屋的位置
        int[] result = new int[queries.length];     // 结果数组
        HashMap<Integer,Integer> leftEndpoint = new HashMap<>();
        HashMap<Integer,Integer> rightEndpoint = new HashMap<>();
        int maxSegment = 0;
        for (int i = 0; i < queries.length; i++) {
            int pos = queries[i];

            // 将当前房屋放入houses集合中
            houses.add(pos);

            // 找到左邻居和右邻居
            Integer leftNeighbor = houses.lower(pos); // 获取小于当前房屋位置的最近邻居
            Integer rightNeighbor = houses.higher(pos); // 获取大于当前房屋位置的最近邻居
            int left = pos,right = pos;
            // 计算当前段的长度
            int currentSegment = 1;  // 当前房屋自成一个段，长度为1



            // 判断是否和左侧相邻
            if (leftNeighbor != null && leftNeighbor == pos - 1&&rightEndpoint.containsKey(leftNeighbor)) {
               int leftEnd = rightEndpoint.get(leftNeighbor);
               rightEndpoint.remove(leftNeighbor);
               left = leftEnd;
            }

            // 判断是否和右侧相邻
            if (rightNeighbor != null && rightNeighbor == pos + 1 && leftEndpoint.containsKey(rightNeighbor)) {
                int rightEnd = leftEndpoint.get(rightNeighbor);
                leftEndpoint.remove(rightNeighbor);
                right = rightEnd;
            }

            leftEndpoint.put(left,right);
            rightEndpoint.put(right,left);
            currentSegment = Math.max(right-left+1,currentSegment);

            // 更新最大连续段的长度
            maxSegment = Math.max(maxSegment, currentSegment);

            // 保存结果
            result[i] = maxSegment;
        }

        return result;
    }

    public static void main(String[] args) {
        HouseSegment sol = new HouseSegment();
        int[] queries = {2, 1, 3,6,7,8,9};
        int[] result = sol.solution(queries);
        System.out.println(Arrays.toString(result)); // 输出 [1, 2, 3]
    }
}
