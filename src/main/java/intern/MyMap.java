package intern;

import java.util.HashMap;

public class MyMap {
    HashMap<Integer,Integer> map = new HashMap<>();

    void insert(int[] keyValue){
        int key = keyValue[0];
        int value = keyValue[1];
        map.put(key,value);
    }

}
