package lc.top150.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC146 {
    class LRUCache {
        private int capacity;
        private HashMap<Integer,Integer> vals;


        private LinkedList<Integer> queue ;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.vals = new HashMap<>();
            this.queue = new LinkedList<>();
        }

        public int get(int key) {
            if(vals.containsKey(key)) {
                queue.remove(Integer.valueOf(key));
                queue.addLast(key);

                return vals.get(key);
            }

            return -1;
        }

        public void put(int key, int value) {

            if(vals.containsKey(key)){
                queue.remove(Integer.valueOf(key));
            }else {
                if(capacity == queue.size()){
                    int k = queue.pollFirst();
                    vals.remove(k);
                }
            }
            queue.addLast(key);
            vals.put(key,value);

        }
    }

    public static void main(String[] args) {

    }
}
