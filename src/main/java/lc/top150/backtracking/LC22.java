package lc.top150.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class LC22 {
    List<String> strings ;
    public List<String> generateParenthesis(int n) {
        strings = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('(',n-1);
        map.put(')',n);
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        backTrackingGenPar(map,stack,n);
        return strings;
    }

    private void backTrackingGenPar(HashMap<Character, Integer> map, Stack<Character> stack, int n) {
        if (stack.size() == 2*n){
         strings.add(   stack.stream().map(String::valueOf)
                    .collect(Collectors.joining())
         );
        }
       if (map.get(')')>map.get('(')){
           if ( map.get('(')>0) {
               stack.push('(');
               map.put('(', map.get('(') - 1);
               backTrackingGenPar(map, stack, n);
               stack.pop();
               map.put('(', map.get('(') + 1);
           }
           if (map.get(')')>0){
               stack.push(')');
               map.put(')',map.get(')')-1);
               backTrackingGenPar(map,stack,n);
               stack.pop();
               map.put(')',map.get(')')+1);
           }
        }
       if (map.get(')')==map.get('(') && map.get('(')>0){
           stack.push('(');
           map.put('(', map.get('(') - 1);
           backTrackingGenPar(map, stack, n);
           stack.pop();
           map.put('(', map.get('(') + 1);
       }
    }

    public static void main(String[] args) {
        LC22 lc = new LC22();
        System.out.println(lc.generateParenthesis(3));
    }
}
