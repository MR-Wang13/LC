package lc.stackqueue;

import java.util.Stack;

public class UseStackToQueue {
    static class MyQueue{
        Stack inStack = new Stack<Integer>();
        Stack outStack = new Stack<Integer>();
        void push(Integer i){
            inStack.push(i);
        }
        void pop(){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            System.out.println(outStack.pop());
        }

        void peek(){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            System.out.println(outStack.peek());

        }
        boolean empty(){
            return inStack.isEmpty()&&outStack.isEmpty();
        }

        public static void main(String[] args) {
            MyQueue queue = new MyQueue();
            queue.push(1);
            queue.push(2);
            queue.peek();
            queue.pop();
            queue.empty();
        }
    }
}
