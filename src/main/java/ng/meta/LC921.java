package ng.meta;

import java.util.Stack;

public class LC921 {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()){
            if(stack.isEmpty()){
                stack.push(s.charAt(index));
            }else {
                if(stack.peek() == '(' && s.charAt(index) == ')'){
                    stack.pop();
                }else {
                    stack.push(s.charAt(index));
                }
            }
            index++;
        }
        return stack.size();
    }
    public static int minAddToMakeValidNotStack(String s) {
        int left = 0, misMatch = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                left++;
            }else {
                if(left > 0){
                    left--;
                }else {
                    misMatch++;
                }
            }
        }
        return left+misMatch;
    }
}
