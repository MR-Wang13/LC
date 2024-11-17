package ng.meta;

import java.util.*;

public class LC398 {
    Map<Integer, List<Integer>> map ;
    public LC398(int[] nums) {
        map = new HashMap<>();
        for( int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
