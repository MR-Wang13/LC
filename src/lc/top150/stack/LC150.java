package lc.top150.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] tokens) {
        HashSet<String> ops = new HashSet();
        ops.add("/");
        ops.add("*");
        ops.add("+");
        ops.add("-");
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if (ops.contains(s)){
                int num1 = stack.pop();
                int num2 = stack.pop();

                switch (s){
                    case "/":
                        stack.push(num2/num1);
                        break;
                    case "*":
                        stack.push(num2*num1);
                        break;
                    case "+":
                        stack.push(num2+num1);
                        break;
                    case "-":
                        stack.push(num2-num1);

                }
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
