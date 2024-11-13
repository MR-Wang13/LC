package ng.meta;

import java.util.HashSet;
import java.util.Stack;

public class LC1249 {
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == ')'){
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    char first = s.charAt(stack.peek());
                    if(c == ')' && first == '('){
                        stack.pop();
                    }else{
                        stack.push(i);
                    }
                }
            }
        }
        set.addAll(stack.stream().toList());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        minRemoveToMakeValid("))((");
    }
}
