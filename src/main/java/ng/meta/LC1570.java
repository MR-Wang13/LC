package ng.meta;

import java.util.HashMap;
import java.util.Map;

public class LC1570 {
    class SparseVector {
        Map<Integer, Integer> valMap = new HashMap<>();
        SparseVector(int[] nums){
            for (int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    valMap.put(i, nums[i]);
                }
            }
        }
        public int dotProduct(SparseVector vec) {
            Map<Integer, Integer> smaller = vec.valMap.size() < valMap.size()?vec.valMap: valMap;
            Map<Integer, Integer> bigger = vec.valMap.size() > valMap.size()?vec.valMap: valMap;
            int productSum = 0;
            for(Map.Entry<Integer, Integer> entry : smaller.entrySet()){
                int index = entry.getKey();
                int val = entry.getValue();
                productSum += val * bigger.getOrDefault(index, 0);
            }
            return productSum;
        }
    }
}
