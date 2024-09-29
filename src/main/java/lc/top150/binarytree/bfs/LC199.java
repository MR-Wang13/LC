package lc.top150.binarytree.bfs;

import lc.top150.binarytree.TreeNode;

import java.util.*;

public class LC199 {
    List<Integer> result ;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ; i<size ; i++){
                TreeNode node = queue.poll();
                if (i == size-1){
                    result.add(node.val);
                }
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }

            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node1.left=node2;
        LC199 lc = new LC199();
        System.out.println(lc.rightSideView(node1));
    }
}
