package lc.tree;

import lc.TreeNode;

public class LowestCommonAncestorOfaBinarySearchTree {
    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            if (root.val>p.val && root.val>q.val){
                root = root.left;
            }else if (root.val<p.val && root.val<q.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(2);
        TreeNode node2  = new TreeNode(1);

        TreeNode node3  = new TreeNode(4);
        TreeNode node4  = new TreeNode(3);
        TreeNode node5  = new TreeNode(5);
        TreeNode node6  = new TreeNode(6);
        TreeNode node7  = new TreeNode(7);
        TreeNode node8  = new TreeNode(8);
        TreeNode node9  = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right=node5;
        System.out.println(lowestCommonAncestor(node1,node4,node5).val);
    }
}
