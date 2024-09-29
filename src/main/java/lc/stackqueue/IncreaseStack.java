package lc.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class IncreaseStack {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);  // 初始化结果数组为 -1
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            // 栈内保持递减顺序，如果当前元素大于栈顶元素，则更新栈顶元素的结果
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);  // 将当前元素的索引入栈
        }

        return res;
    }

    public static void main(String[] args) {
        IncreaseStack solution = new IncreaseStack();

        // 测试用例
        int[] nums = {2, 1, 2, 4, 3};
        int[] result = solution.nextGreaterElements(nums);

        // 输出结果
        System.out.println(Arrays.toString(result));
    }

}
