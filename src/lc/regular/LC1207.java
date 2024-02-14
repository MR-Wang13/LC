package lc.regular;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for (int val : map.values()){
            if (set.contains(val)){
                return false;
            }
            set.add(val);
        };
        return true;
    }
}
