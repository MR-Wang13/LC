package lc.top150.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LC402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    String solution(String num, int k){
        Deque<Character> deque = new LinkedList<>();

        for (char c : num.toCharArray()){
            while (!deque.isEmpty()&&c<deque.peekLast()&&k>0){
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }

        return "";
    }

    public static void main(String[] args) {
        LC402 lc =  new LC402();
        System.out.println(lc.removeKdigits("1432219", 3));
    }
}
