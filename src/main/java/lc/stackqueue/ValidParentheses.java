package lc.stackqueue;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c: s.toCharArray()){
            if (c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                char left = stack.peek();
                switch (c){
                    case ')':
                        if (left != '('){
                            return false;
                        }
                        break;
                    case '}':
                        if (left != '{'){
                            return false;
                        }
                        break;
                    case ']':
                        if (left != '['){
                            return false;
                        }
                        break;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[){}"));
    }
}
