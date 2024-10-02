import java.util.HashMap;

public class TreeTest {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /**
     * 将有序数组转换为二叉搜索树
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     *
     * 示例 2：
     *
     *
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 按 严格递增 顺序排列

     * */

    /**
     * 递归解法
     *
     * 有子结构----一旦涉及子问题使用递归解法
     *
     *
     *
     * **/
    public static TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0,nums.length-1);
    }

    private static TreeNode recursion(int[] nums, int start, int end) {
        if (end<start){
            return null;
        }
        //选择中间节点作为根节点
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums,start,mid-1);
        root.right = recursion(nums,mid+1,end);

        return root;
    }


    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode node =  sortedArrayToBST(nums);
        System.out.println(node);
    }
}
