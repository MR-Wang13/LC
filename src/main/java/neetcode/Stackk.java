package neetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Stackk {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String s : tokens){
            if(s.equals( "+") || s.equals( "-")|| s.equals( "*")|| s.equals( "/")){
                int b = stack.pop();
                int a = stack.pop();
                int result = caculate(a,b,s);
                stack.push(result);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
    public static int caculate(int a, int b, String op){
        return switch (op) {
            case "*" -> a * b;
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            default -> 0;
        };
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result  = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', n);
        map.put(')', n);
        Stack<Character> stack = new Stack();
        backTracking(map,stack,result);
        return result;
    }
    public static void backTracking(HashMap<Character, Integer> map,Stack<Character> stack,List<String> result ) {
        if(map.get('(') == 0 && map.get(')') == 0){
            result.add(stack.stream().map(String :: valueOf).collect(Collectors.joining()));
            return;
        }
        if(map.get('(')> 0){
            processParenthesis('(',map,stack,result);
        }

        if(map.get(')') >0 && map.get(')') >map.get('(')){
            processParenthesis(')',map,stack,result);
        }
    }
    public  static void processParenthesis(char c ,HashMap<Character, Integer> map,Stack<Character> stack,List<String> result ){
        stack.push(c);
        map.put(c,map.get(c)-1);
        backTracking(map,stack,result);
        stack.pop();
        map.put(c,map.get(c)+1);
    }

    static int[] sortKMessedArray(int[] arr, int k) {
        Deque<Integer> minStack = new ArrayDeque<>();
        int n = arr.length;
        for(int i =0 ; i<=k && i<n ; i++){
            if(!minStack.isEmpty()){
                int min = minStack.peek();
                if(arr[i] < min){
                    minStack.add(arr[i]);
                }else{
                    minStack.add(min);
                }
            }else{
                minStack.add(arr[i]);
            }
        }
        int index = 0;
        for(int i = k+1 ; i<n; i++){
            arr[index++] = minStack.pollFirst();
            int min = minStack.peek();
            if(arr[i] < min){
                minStack.add(arr[i]);
            }else{
                minStack.add(min);
            }
        }
        while(!minStack.isEmpty()){
            arr[index++] = minStack.pollFirst();
        }
        return arr;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0 ; i < n; i++){
            int asteroid = asteroids[i];
            if(stack.isEmpty()){
                stack.push(asteroid);
            }else {
                if(asteroid < 0 && stack.peek() > 0){
                    while(!stack.isEmpty() && stack.peek() > 0 && (asteroid + stack.peek()) < 0 ){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        stack.push(asteroid);
                    }else {
                        if((asteroid + stack.peek()) == 0){
                            stack.pop();
                        }else if(stack.peek() < 0){
                            stack.push(asteroid);
                        }

                    }

                }else {
                    stack.push(asteroid);
                }
            }
        }
        int[] result = new int[stack.size()];
        int index = stack.size() -1;
        while(!stack.isEmpty()){
            result[index--] = stack.pop();
        }
        return result;
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 &&
                    stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }
        return stack.size();

    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack();
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        int maxRec = 0;
        for(int i = 0; i < n; i++){
            leftMost[i] = -1;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i] ){
                stack.pop();
            }
            if(!stack.isEmpty()){
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--){
            rightMost[i] = n;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i] ){
                stack.pop();
            }
            if(!stack.isEmpty()){
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i = 0; i < n; i++){
            maxRec = Math.max(maxRec, (rightMost[i] - leftMost[i] - 1) * heights[i]);
        }

        return maxRec;
    }

    public static int largestRectangleAreaOp(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // pair: (index, height)

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
    public static void main(String[] args) {
        //String[] tokens={"4","13","5","/","+"};
        //System.out.println(generateParenthesis(3));
        //sortKMessedArray(new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9},2);
        //asteroidCollision(new int[]{5,10,-5});
        /*int target = 100;
        int[] position = {20,35,50,90};
        int[] speed = {20,15,10,1};
        System.out.println(carFleet(target,position,speed));*/
        int[] heights={7,6,5,2,2,4};
        System.out.println(largestRectangleAreaOp(heights));

    }
}
