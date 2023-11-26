package lc.tree;

import lc.TreeNode;

public class SymmetricTree {
    static public boolean isSymmetric(TreeNode root) {
        return compareTree(root.left,root.right);
    }

    private static boolean compareTree(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return compareTree(left.left,right.right) && compareTree(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(1);
        TreeNode node2  = new TreeNode(2);

        TreeNode node3  = new TreeNode(2);
        TreeNode node4  = new TreeNode(3);
        TreeNode node5  = new TreeNode(4);
        TreeNode node6  = new TreeNode(6);
        TreeNode node7  = new TreeNode(7);
        TreeNode node8  = new TreeNode(8);
        TreeNode node9  = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        System.out.println(isSymmetric(node1));
    }
}
