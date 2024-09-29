package lc.tree;

import lc.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfBinaryTree {
    private static int max = 0;
    static public int maxDepth(TreeNode root) {
        max = 0;
        if (root == null){
            return 0;
        }
        findDepth(root.left,1);
        findDepth(root.right,1);
        return max;
    }

    static public int maxDepthRecursion(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftLength = maxDepthRecursion(root.left);
        int rightLength = maxDepthRecursion(root.right);
        return Math.max(leftLength,rightLength)+1;
    }
    static public int maxDepthIteration(TreeNode root) {
        if (root == null){
            return 0;
        }
        int depth = 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            depth++;
            while (size-->0){
                TreeNode  node =deque.poll();
                if (node.right!=null){
                    deque.offer(node.right);
                }
                if (node.left!=null){
                    deque.offer(node.left);
                }
            }
        }

        return depth;
    }

    private static void findDepth(TreeNode root, int deep) {
        if (root == null){
            if (max<deep){
                max = deep;
            }
            return;
        }
        findDepth(root.left,deep+1);
        findDepth(root.right,deep+1);
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
        //node2.left = node4;
        //node2.right = node5;

        System.out.println(maxDepthRecursion(node1));
    }
}
