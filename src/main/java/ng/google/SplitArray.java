package ng.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

public class SplitArray {
    static class MyQueue{
        Deque<Integer> deque ;

        MyQueue(){
            deque = new ArrayDeque<>();
        }
        public void add(int num){
            while (!deque.isEmpty() && deque.getLast()>num){
                deque.removeLast();
            }
            deque.add(num);
        }

        public void poll(int num){
            if(num == deque.peek()){
                deque.poll();
            }
        }
        public int getMin(){
            return deque.peek();
        }
    }
    public static int getWaysToSplit(int[] nums){
        int n = nums.length;
        if(n <= 1){
            return 0;
        }

        int splitPoint = 0;
        int maxOfLeft = nums[0];
        MyQueue rightQ = new MyQueue();
        for(int i = splitPoint+1; i < n ;i++){
            rightQ.add(nums[i]);
        }
        int ways=0;
        while (splitPoint < n-1){
            if(rightQ.getMin()>=maxOfLeft){
                ways++;
            }
            splitPoint++;
            maxOfLeft = Math.max(maxOfLeft,nums[splitPoint]);
            rightQ.poll(nums[splitPoint]);
        }
        return ways;
    }

    public static void main(String[] args) {
        getWaysToSplit(new int[]{4,3,2,1});

        Deque<Integer> deque  = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        System.out.println(deque.peek());
        System.out.println(deque.getLast());
    }
}
