package lc.tree;

import lc.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountCompleteTreeNodes {
    static public int countNodes(TreeNode root) {
        return travelTree(root);
    }

    static private int travelTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                TreeNode node = queue.poll();
                count++;
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
        }
        return count;
    }
    static private int travelTreeRecursion(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1+travelTreeRecursion(root.left)+travelTreeRecursion(root.right);
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
        System.out.println(travelTreeRecursion(node1));
    }
}
