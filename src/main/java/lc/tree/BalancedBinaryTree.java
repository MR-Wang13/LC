package lc.tree;

import lc.TreeNode;

public class BalancedBinaryTree {
        static boolean isBalanced = true;
        static public boolean isBalanced(TreeNode root) {
            isBalanced = true;
            treeHeight(root);
            return isBalanced;
        }

        static private int treeHeight(TreeNode root) {
            if (root == null){
                return 0;
            }
            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);
            if (Math.abs(leftHeight - rightHeight)>1){
                isBalanced=false;
            }
            return 1+Math.max(leftHeight,rightHeight);
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
        node1.right = node2;
        //node1.right = node3;
        node2.right = node4;
        //node4.right=node5;
        System.out.println(isBalanced(node1));
    }
}
