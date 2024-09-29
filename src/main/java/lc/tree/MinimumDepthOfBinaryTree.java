package lc.tree;

import lc.TreeNode;

public class MinimumDepthOfBinaryTree {
    static private int min = 100000;
    static public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }        if(root.left!=null)
            findMinDepth(root.left, 2);
        if(root.right!=null)
            findMinDepth(root.right, 2);
        return min;
    }

    static void findMinDepth(TreeNode root , int depth){
        if(root.left == null && root.right == null){
            if(min>depth){
                min = depth;
            }
            return ;
        }
        if(root.left!=null)
            findMinDepth(root.left, depth+1);
        if(root.right!=null)
            findMinDepth(root.right, depth+1);
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
        node3.left = node4;
        node3.right = node5;
        System.out.println(minDepth(node1));
    }
}
