package ng.amazon;

import java.util.Map;
import java.util.TreeMap;

public class StickRectangles {
    public static int maxRectangleArea(int[] sideLengths) {
        TreeMap<Integer, Integer> lengthCount = new TreeMap<>();

        // Count occurrences of each length
        for (int length : sideLengths) {
            lengthCount.put(length, lengthCount.getOrDefault(length, 0) + 1);
        }

        long areaSum = 0;
        int mod = 1000000007;
        TreeMap<Integer, Integer> newLengthCount = new TreeMap<>(); // To hold leftover sticks that could be matched by reducing one

        // Traverse lengths in descending order
        for (Map.Entry<Integer, Integer> entry : lengthCount.descendingMap().entrySet()) {
            int length = entry.getKey();
            int count = entry.getValue()+newLengthCount.getOrDefault(length,0);

            if (count%2==1){
                newLengthCount.put(length-1,newLengthCount.getOrDefault(length-1,0)+1);
                newLengthCount.put(length,count-1);
            }else {
                newLengthCount.put(length,count);
            }
        }
        int pre =-1;

        for (Map.Entry<Integer, Integer> entry : newLengthCount.descendingMap().entrySet()) {
            int length = entry.getKey();
            int count = entry.getValue();
            if (count>=2){
                if (pre!=-1) {
                   count= count-2;
                    int area = (pre * length ) % mod;
                    areaSum += area;
                    areaSum %= mod;
                }

                int pair = count / 4;
                int area = (length * length * pair) % mod;
                areaSum += area;
                areaSum %= mod;
                count = count%4;
                if (count>=2){
                    pre=length;
                }else {
                    pre = -1;
                }
            }
        }
        return (int) areaSum;
    }

    public static void main(String[] args) {
        int[] sideLengths = {2, 6, 2, 3, 5,6,6,3};
        System.out.println("Maximum sum of areas: " + maxRectangleArea(sideLengths));
    }
}
