package lc.tree;

import lc.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Level {
    static public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    static public List<List<Integer>> levelOrder(TreeNode root) {

        //levelDFS(root,0);
        levelBFS(root);
        return resList;
    }

    static private void levelDFS(TreeNode root, int deep) {
        if (root == null)
            return;

        if (deep>=resList.size()){
            List<Integer> list = new ArrayList<>();
            resList.add(list);
        }

        resList.get(deep).add(root.val);

        levelDFS(root.left,deep+1);
        levelDFS(root.right,deep+1);
    }


    static private void levelBFS(TreeNode root) {
        if (root == null)
            return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            while (length>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
                length--;
            }
            resList.add(list);
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
        node2.left = node4;
        node2.right = node5;

        levelOrder(node1);

    }
}
