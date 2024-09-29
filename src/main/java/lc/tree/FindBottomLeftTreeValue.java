package lc.tree;

import lc.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    static public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0 ; i<size; i++){
                TreeNode node = queue.poll();
                if (i==0){
                    result = node.val;
                }
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
        }
        return result;
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
        node2.right = node4;
        node3.right=node5;
        System.out.println(findBottomLeftValue(node1));
    }
}
