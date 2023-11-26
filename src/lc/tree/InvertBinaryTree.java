package lc.tree;

import lc.TreeNode;

public class InvertBinaryTree {
    static public TreeNode invertTree(TreeNode root) {
        swapTree(root);
        return root;
    }

    private static void swapTree(TreeNode root) {
        if (root == null){
            return ;
        }
        swapNode(root);
        swapTree(root.left);
        swapTree(root.right);
    }

    private static void swapNode(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


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
        node2.right = node5;

        invertTree(node1);
    }

}
