package intern.purestorage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindDouble {
    static void findDoubles(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        for (int num: nums){
            if (map.get(num)==null){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);

            }

            int doubleNum = num * 2;
            if (map.get(doubleNum)!=null && map.get(doubleNum)==1){
                result.add(num);

            }else if(map.get(doubleNum)!=null &&map.get(doubleNum)==2){
                result.remove(num);
            }
            if (num%2==0){
                int divided = num/2;
                if (map.get(divided)!=null){
                    result.add(divided);
                }
                if(map.get(num)!=null &&map.get(num)==2){
                    result.remove(divided);
                }
            }
        }
        for (int n : result) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        findDoubles(nums);
    }
}
