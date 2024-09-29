package lc.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        List<String> lists = new ArrayList<>();
        lists.add("+");
        lists.add("-");
        lists.add("*");
        lists.add("/");
        Stack<String> stack = new Stack<>();
        for (String s : tokens){


            if(lists.contains(s)){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (s){
                    case "+":
                        stack.push(String.valueOf(a+b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b-a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a*b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }else {
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
}
