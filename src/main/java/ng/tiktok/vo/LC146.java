package ng.tiktok.vo;

import java.util.*;

public class LC146 {
    static class LRUCache {

        Map<Integer,Integer> map;

        int capacity;
        TreeMap<Integer,Integer> treeMap;
        public LRUCache(int capacity) {
            treeMap = new TreeMap<>((o1, o2) -> treeMap.get(o1)-treeMap.get(o2));
            this.capacity =capacity;
            map = new HashMap<>();
        }

        public int get(int key) {
            if(!map.containsKey(key)){
               return -1;
            }
            treeMap.put(key,treeMap.get(key)+1);
            return map.get(key);
        }

        public void put(int key, int value) {
            if(map.size()==capacity){
                map.remove(treeMap.firstKey());
                treeMap.pollFirstEntry();
                treeMap.put(key, 0);
                map.put(key,value);
            }else {
                treeMap.put(key,0);
                map.put(key,value);
            }

        }

        public static void main(String[] args) {
            LRUCache lruCache = new LRUCache(2);
            lruCache.put(1,1);
            lruCache.put(2,2);
        }
    }
}
