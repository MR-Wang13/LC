package lc.tree;

import lc.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class recursion {
    static public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorder(root,result);

        return result;
    }

    private static void preorder(TreeNode root, List<Integer> result) {
        if (root==null){
            return;
        }
        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
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

        preorderTraversal(node1);
        //inorderTraversal(node1);
        //postorderTraversal(node1);
    }
}
