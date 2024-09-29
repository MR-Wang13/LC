package lc.tree;

import lc.TreeNode;

public class MergeTwoBinaryTrees {
    static public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode pre1 = new TreeNode(-1);
        pre1.left = root1;
       /* TreeNode pre2 = new TreeNode(-1);

        pre2.left = root2;
        mergeTree(pre1,pre2);*/
        return mergeTree2(root1,root2);
    }
    private static TreeNode mergeTree2(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }

        root1.val+=root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);

        return root1;

    }
    private static void mergeTree(TreeNode root1, TreeNode root2) {

        if (root1.left == null && root2.left!=null){
            TreeNode node = new TreeNode(root2.left.val);
            root1.left = node;
        }
        if (root1.left != null && root2.left!=null){
            root1.left.val +=  root2.left.val;
        }
        if (root1.right == null && root2.right!=null){
            TreeNode node = new TreeNode(root2.right.val);
            root1.right = node;
        }
        if (root1.right != null && root2.right!=null){
            root1.right.val +=  root2.right.val;
        }

        if (root1.left!=null || root2.left!=null){
            mergeTree(root1.left,root2.left);
        }

        if (root1.right!=null || root2.right!=null){
            mergeTree(root1.right,root2.right);
        }
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
        node4.left = node5;
        node4.right=node6;
        System.out.println(mergeTrees(node1,node4));
    }
}
