package intern;

import java.util.Stack;

public class Main2 {
    public static String markUnmatched(String s) {
        StringBuilder result = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    // 为多余的闭合括号标记 'x'
                    result.setCharAt(i, '?');
                } else {
                    stack.pop();
                }
            }
        }

        // 对所有未匹配的打开括号标记 '?'
        while (!stack.isEmpty()) {
            int pos = stack.pop();
            result.setCharAt(pos, 'x');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "bge)))))))))";
        String input2 = "()()()()(uuu";

        System.out.println("Processed Input 1: " + markUnmatched(input1));
        System.out.println("Processed Input 2: " + markUnmatched(input2));
    }

}
