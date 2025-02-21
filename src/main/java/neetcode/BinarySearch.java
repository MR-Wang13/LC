package neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinarySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        int row = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] > target){
                right = mid -1;
                row = right;
            }else{
                row = left;
                left = mid + 1;
            }
        }
        if(row<0 || row >= m){
            return false;
        }
        left = 0;
        right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
    static class TimeMap {

        Map<String, ArrayList<Integer>> tmap;
        Map<String, Map<Integer,String>> vmap;
        public TimeMap() {
            tmap = new HashMap<>();
            vmap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {


            tmap.computeIfAbsent(key, k -> new ArrayList()).add(timestamp);
            vmap.computeIfAbsent(key, k -> new HashMap<>()).put(timestamp, value);

        }

        public String get(String key, int timestamp) {
            ArrayList<Integer> list = tmap.get(key);
            if(!tmap.containsKey(key) || list.get(0) > timestamp){
                return "";
            }

            if(list.get(list.size() - 1) < timestamp){
                return vmap.get(key).get(list.get(list.size() - 1));
            }

            int left = 0, right = list.size() - 1;
            int index = -1;
            while(left<=right){
                int mid = left + (right - left) / 2;
                if(list.get(mid) > timestamp){
                    right = mid - 1;
                }else if (list.get(mid) < timestamp){
                    index = mid;
                    left = mid + 1;
                }else{
                    index = mid;
                    break;
                }
            }


            return vmap.get(key).get(list.get(index));

        }
    }

    public static void main(String[] args) {
       /* int[][] matrix  = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 61;
        System.out.println(searchMatrix(matrix,target));*/

        TimeMap timeMap = new TimeMap();
        timeMap.set("test", "v1", 10);
        timeMap.set("test", "v2", 20);
        timeMap.set("test", "v3", 30);
        System.out.println(timeMap.get("test",15));
        System.out.println(timeMap.get("test",25));
        System.out.println(timeMap.get("test",35));
    }
}
