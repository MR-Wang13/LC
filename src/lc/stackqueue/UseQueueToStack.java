package lc.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class UseQueueToStack {
    static class MyStack {
        ArrayDeque<Integer> myQueue = new ArrayDeque();
        public MyStack() {

        }

        public void push(int x) {
            myQueue.push(x);

            int size = myQueue.size();
            while (size-->0){
                myQueue.add(myQueue.peekFirst());
                myQueue.pollFirst();
            }
        }

        public int pop() {
            int res = myQueue.peekFirst();
            myQueue.poll();
            return res;
        }

        public int top() {
            return myQueue.peek();
        }

        public boolean empty() {
            return myQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack queue = new MyStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.top());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
