package lc.String;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s){
        char[] chars = s.toCharArray();
        int length =0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<chars.length ; i++){
            if (chars[i]=='('){
                stack.push(i);
            }else {
                if (stack.isEmpty()){
                    start = i ;
                }else {
                    stack.pop();
                    if (stack.isEmpty()){
                        length=Math.max(length,i-start+1);
                    }else {
                        length = Math.max(length, i - stack.peek());
                    }
                }
            }
        }
        return length;
    }
}
