package ng.meta;

import java.util.*;

public class LC239 {
    class MyQueue{
        Deque<Integer> queue = new LinkedList<>();
        public void add(int num){
            while (!queue.isEmpty() && queue.getFirst() < num){
                queue.removeFirst();
            }
            queue.addFirst(num);
        }
        public void poll(int num){
            if(num == queue.getLast()){
                queue.removeLast();
            }
        }
        public int peek(){
            return queue.getLast();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        for(int i = 0; i < k; i++){
            queue.add(nums[i]);
        }
        int left = 0;
        int right = k;
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        result[index++] = queue.peek();
        while (right < nums.length){
            queue.poll(nums[left]);
            queue.add(nums[right]);
            result[index++] = queue.peek();
            left++;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        LC239 lc = new LC239();
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(lc.maxSlidingWindow(nums, k)));
    }
}
