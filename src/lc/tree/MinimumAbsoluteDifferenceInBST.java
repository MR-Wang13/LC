package lc.tree;

import lc.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    static TreeNode pre = null;
    static int min = Integer.MAX_VALUE;

    static public int getMinimumDifference(TreeNode root) {
        pre = null;
        min = Integer.MAX_VALUE;
        inorderTree(root);
        return min;
    }

    private static void inorderTree(TreeNode root) {
        if (root == null){
            return;
        }
        inorderTree(root.left);
        if (pre!=null){
            if (root.val-pre.val<min){
                min = root.val-pre.val;
            }
        }
        pre = root;
        inorderTree(root.right);
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
        System.out.println(getMinimumDifference(node1));
    }
}
