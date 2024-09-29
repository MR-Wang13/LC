package lc.stackqueue;

import java.util.*;

public class TopKFrequentElements {
    static public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()- o1.getValue();
            }
        });
        int[] result = new int[k];
        for (int i = 0; i<k ;i++){
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        topKFrequent(nums,k);
    }
}
