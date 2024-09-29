package lc.regular;

import java.util.*;
import java.util.stream.Collectors;

public class RandomizedSet {

    HashSet<Integer> set ;
    Random random ;

    List<Integer> list ;
    HashMap<Integer,Integer> map ;
    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)){
            return false;
        }
        set.add(val);
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)){
            return false;
        }
        int index = map.get(val);
        list.set(index,list.get(list.size()-1));
        map.put(list.get(list.size()-1),index);
        list.remove(list.size()-1);
        map.remove(val);
        set.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        Random random1 = new Random();
        System.out.println(random1.nextInt(10));
    }
}
