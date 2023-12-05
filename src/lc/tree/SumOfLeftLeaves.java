package lc.tree;

import lc.TreeNode;

public class SumOfLeftLeaves {

    static public int sumOfLeftLeaves(TreeNode root) {
        return travelLeft(root);
    }

    static private int travelLeft(TreeNode root) {
        if (root == null){
            return 0;
        }
        int val = 0;
        if (root.left!=null && root.left.left == null && root.left.right == null){
            val = root.left.val;
        }

        return val+travelLeft(root.left)+travelLeft(root.right);
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
        node1.right = node3;
        node2.left = node4;
        //node4.right=node5;
        System.out.println(sumOfLeftLeaves(node1));
    }
}
