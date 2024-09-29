package lc.top150.stack;

import java.util.*;

public class LC155 {

    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    public LC155() {

    }

    public void push(int val) {
        if (stack.isEmpty()){
            list.add(val);
        }else {
            list.add(list.get(list.size()-1)>val?val:list.get(list.size()-1));
        }
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        list.remove(list.size()-1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(list.size()-1);
    }
}
