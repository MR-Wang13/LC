package ng.meta;

import java.util.Stack;

public class LC227 {
    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        while(index < s.length()){
            while(index < s.length() && " ".equals(String.valueOf(s.charAt(index)))){
                index++;
            }
            String str ;
            if(Character.isDigit(s.charAt(index))){
                StringBuilder sb = new StringBuilder();
                while(index < s.length() && Character.isDigit(s.charAt(index)) ){
                    sb.append(String.valueOf(s.charAt(index++)));
                }
                str = sb.toString();
            }else {
                str = String.valueOf(s.charAt(index++));
            }

            while(index < s.length() && " ".equals(String.valueOf(s.charAt(index)))){
                index++;
            }
            if(!stack.isEmpty()){
                int a ,b, result;
                switch (stack.peek()){
                    case "*":
                        stack.pop();
                        a = Integer.valueOf(stack.pop());
                        b = Integer.valueOf(str);
                        result =  a * b;
                        stack.push(String.valueOf(result));
                        break;
                    case "/":
                        stack.pop();
                        a = Integer.valueOf(stack.pop());
                        b = Integer.valueOf(str);
                        result =  a / b;
                        stack.push(String.valueOf(result));
                        break;
                    case "-":
                        stack.pop();
                        stack.push("-"+str);
                        break;
                    case "+":
                        stack.pop();
                        stack.push(str);
                        break;
                    default:
                        stack.push(str);

                }
            }else{
                stack.push(str);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            ans += Integer.valueOf(stack.pop());
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculate("0-2147483647"));
    }
}
