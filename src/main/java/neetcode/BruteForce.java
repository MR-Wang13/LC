package neetcode;

import java.util.TreeMap;

public class BruteForce {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int value : hand){
            treeMap.put(value, treeMap.getOrDefault(value, 0) + 1);
        }

        int groups = n / groupSize;

        while (groups-- >0){
            int size = groupSize;
            int cur = treeMap.firstKey();
            while (size -- >0 && treeMap.containsKey(cur) ){
                treeMap.put(cur, treeMap.get(cur) - 1);
                if(treeMap.get(cur) == 0){
                    treeMap.remove(cur);
                }
                cur++;
            }
            if(size >= 0){
                return false;
            }
        }
        return groups < 0;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,4,2,3,5,3,7};
        int groupSize = 4;
        System.out.println(isNStraightHand(hand,groupSize));
    }
}
