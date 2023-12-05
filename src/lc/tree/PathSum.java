package lc.tree;

import lc.TreeNode;

public class PathSum {
    static public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return !findPathSum(root,targetSum,0);
    }

    static private boolean findPathSum(TreeNode root, int targetSum, int sum) {
        if (root == null){
            return true;
        }
        sum+=root.val;

        if (root.left == null && root.right == null){
            return !(targetSum==sum);
        }
        return findPathSum(root.left,targetSum,sum) && findPathSum(root.right,targetSum,sum);
    }
    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(1);
        TreeNode node2  = new TreeNode(2);

        TreeNode node3  = new TreeNode(3);
        TreeNode node4  = new TreeNode(4);
        TreeNode node5  = new TreeNode(5);
        TreeNode node6  = new TreeNode(6);
        TreeNode node7  = new TreeNode(7);
        TreeNode node8  = new TreeNode(8);
        TreeNode node9  = new TreeNode(9);
        node1.left = node2;
        /*node1.right = node3;
        node2.left = node4;
        node2.right=node5;*/
        System.out.println(hasPathSum(node1,1));
    }
}
