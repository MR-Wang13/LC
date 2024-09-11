package ng.amazon;

import java.util.Arrays;

public class WarehouseLocation {
    public static int solution(int[] centers, int d) {
        Arrays.sort(centers);
        int n = centers.length;
        int count=0;
        int max = centers[n-1]+(d/2), min = centers[0]-(d/2);
        int right = findUpperBound(min,max,d,centers),left = findLowerBound(min,max,d,centers);

        if (right!=Integer.MAX_VALUE&&left!=Integer.MAX_VALUE&&left<=right){
            count = right-left+1;
        }


        return count;
    }

    private static int findUpperBound(int left, int right, int d, int[] centers) {
        int bound = Integer.MAX_VALUE;
        while (left<=right){
            int mid = left+ (right-left)/2;
            if (calDistance(mid,centers)<=d){
                bound = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return bound;
    }

    private static int findLowerBound(int left, int right, int d, int[] centers) {
        int bound = Integer.MAX_VALUE;
        while (left<=right){
            int mid = left+ (right-left)/2;
            if (calDistance(mid,centers)<=d){
                bound = mid;
                right = mid-1;


            }else {
                left = mid+1;
            }
        }
        return bound;
    }

    private static int calDistance(int i, int[] centers) {
        int dis = 0;
        for (int center:centers){
            dis+=Math.abs(i-center);
        }
        return dis*2;
    }

    public static int findSuitableLocations(int[] centers, int d) {
        // 设置初始区间范围
        int left = -1000000000;  // 最小可能的 x 值
        int right = 1000000000;  // 最大可能的 x 值

        int suitableLocationsCount = 0;

        // 遍历所有可能的 x 值
        for (int x = left; x <= right; x++) {
            int totalDistance = 0;
            // 计算每个 center[i] 到 x 的往返距离
            for (int center : centers) {
                totalDistance += 2 * Math.abs(x - center);  // 来回距离
                if (totalDistance > d) {
                    break;  // 如果总距离超过 d，跳过这个 x
                }
            }
            // 如果总距离小于或等于 d，则 x 是合适的位置
            if (totalDistance <= d) {
                suitableLocationsCount++;
            }
        }

        return suitableLocationsCount;
    }
    public static void main(String[] args) {
        int[] centers = {-2, 1, 0};
        int d = 8;
        System.out.println(solution(centers, d));  // 输出为 3
    }
}
