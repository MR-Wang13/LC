package ng.uber;

import java.util.Deque;
import java.util.LinkedList;

public class MaxLatency {
    static int getMax(int[] latencies, int thresh) {
        int maxLength = 0;
        int start = 0;

        // Deques to maintain indices of minimum and maximum values in the window
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        for (int end = 0; end < latencies.length; end++) {
            // Update minDeque
            while (!minDeque.isEmpty() && latencies[minDeque.peekLast()] >= latencies[end]) {
                minDeque.pollLast();
            }
            minDeque.addLast(end);

            // Update maxDeque
            while (!maxDeque.isEmpty() && latencies[maxDeque.peekLast()] <= latencies[end]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(end);

            // Check if the current window is valid
            while (!minDeque.isEmpty() && !maxDeque.isEmpty() &&
                    latencies[maxDeque.peekFirst()] - latencies[minDeque.peekFirst()] > thresh) {
                // Adjust the window by moving the start pointer
                if (minDeque.peekFirst() == start) minDeque.pollFirst();
                if (maxDeque.peekFirst() == start) maxDeque.pollFirst();
                start++;
            }

            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] n = {1, 3, 6, 2, 4, 7};
        System.out.println(getMax(n,4));
    }
}
