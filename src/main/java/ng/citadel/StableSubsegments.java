package ng.citadel;

import java.util.*;

public class StableSubsegments {

    public static int countStableSegments(int[] capacity) {
        int n = capacity.length;
        long[] prefixSum = new long[n + 1]; // Prefix sums array

        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + capacity[i];
        }

        // Map to store (capacity, sum) -> list of positions
        Map<Integer, Map<Long, List<Integer>>> map = new HashMap<>();

        // Build the map with positions l
        for (int l = 0; l < n; l++) {
            int cap = capacity[l];
            long sum = prefixSum[l + 1] + cap;

            map.computeIfAbsent(cap, k -> new HashMap<>())
                    .computeIfAbsent(sum, k -> new ArrayList<>())
                    .add(l);
        }

        int count = 0;

        // Iterate over positions r
        for (int r = 0; r < n; r++) {
            int cap = capacity[r];
            long sum = prefixSum[r];

            if (map.containsKey(cap) && map.get(cap).containsKey(sum)) {
                for (int l : map.get(cap).get(sum)) {
                    if (l <= r - 2) { // Ensure subsegment length is at least 3
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // You can include a main method for testing purposes if needed
    public static void main(String[] args) {
        int[] capacity = {9, 3, 3, 3, 9};
        int result = countStableSegments(capacity);
        System.out.println(result); // Output should be 2
    }
}
