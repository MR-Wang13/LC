package lc.stackqueue;

import java.util.*;

public class RemoveAdjacent {
    static String remove(String s){
        Stack<Character> queue = new Stack<>();
        for (char c : s.toCharArray()){
            if (!queue.isEmpty() && queue.peek() == c){
                queue.pop();
            }else {
                queue.add(c);
            }
        }
        int size = queue.size();
        char[] result = new char[size];
        size--;
        while (!queue.isEmpty()){
            result[size--]=(queue.pop());
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(remove("abbaca"));
    }
}
