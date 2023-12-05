package lc.tree;

import lc.TreeNode;

public class ValidateBinarySearchTree {
    static TreeNode max = null;

    static public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        return checkTree2(root);
    }

    static public boolean checkTree2(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left =checkTree2(root.left);
        if(max!=null && max.val >= root.val) {
            return false;
        }
        max = root;
        boolean right =checkTree2(root.right);
        return  left && right;
    }
    static public boolean checkTree(TreeNode root, int val, String side) {
        if (root == null){
            return true;
        }
        if(side.equals("left")) {
           if (val <= root.val) {
                return false;
            }
        }else {
            if (val >= root.val) {
                return false;
            }
        }

        return  checkTree(root.left,val,side) && checkTree(root.right,val,side);
    }
    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(5);
        TreeNode node2  = new TreeNode(1);

        TreeNode node3  = new TreeNode(10);
        TreeNode node4  = new TreeNode(4);
        TreeNode node5  = new TreeNode(11);
        TreeNode node6  = new TreeNode(6);
        TreeNode node7  = new TreeNode(7);
        TreeNode node8  = new TreeNode(8);
        TreeNode node9  = new TreeNode(9);
        //node1.left = node2;
        node1.right = node3;
        //node3.left = node4;
        //node3.right=node5;
        System.out.println(isValidBST(node1));
    }
}
