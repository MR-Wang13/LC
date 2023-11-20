package lc.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum1 {
    static class MyQueue {
        Deque<Integer> queue = new ArrayDeque<>();
        public void poll(int num){
            if (queue.size()>0 && queue.peek() == num){
                queue.poll();
            }
        }
        public void add(int num ){
            while (queue.size()>0 && queue.getLast()<num){
                queue.removeLast();
            }
            queue.add(num);
        }
        public Integer peek(){
            return queue.peek();
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 1) {
            return nums;
        }
        int[] result = new int[nums.length-k+1];
        MyQueue queue = new MyQueue();
        for (int i = 0 ; i<k;i++){
            queue.add(nums[i]);
        }
        int index = 0;
        for (int i =k ; i<nums.length; i++){
            result[index] = queue.peek();
            queue.poll(nums[index++]);
            queue.add(nums[i]);
        }
        result[index] = queue.peek();
        return result;

    }

    public static void main(String[] args) {
       int[] nums = {1,3,1,2,0,5};
       int k = 3;
        maxSlidingWindow(nums,k);
    }
}
