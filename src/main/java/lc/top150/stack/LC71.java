package lc.top150.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC71 {
    /**
     * stack is synchronized making it thread-safe but it also makes it slower
     *
     * ArrayDeque has higher performance
     * */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dict = path.split("/");
        for (String d : dict){
            if (d.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else if(d.equals(".")||d.isEmpty()){

            }else {
                stack.push(d);
            }
        }
        return "/"+String.join("/",stack);
    }

    public static void main(String[] args) {
        LC71 lc = new LC71();
        String path = "/a//b////c/d//././/..";
        System.out.println(lc.simplifyPath(path));
    }
}
