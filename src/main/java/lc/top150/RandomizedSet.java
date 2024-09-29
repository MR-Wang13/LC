package lc.top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {

        HashMap<Integer,Integer> map ;
        ArrayList<Integer> list ;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.get(val)!=null){
                return false;
            }else {
                map.put(val,list.size());
                list.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (map.get(val)!=null){
                int index = map.get(val);
                list.set(index,list.get(list.size()-1));
                map.put(list.get(list.size()-1),index);
                list.remove(list.size()-1);
                map.remove(val);
                return true;
            }else {
                return false;
            }

        }

        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.remove(1);
        set.insert(2);
        System.out.println(set.getRandom());
    }
}
