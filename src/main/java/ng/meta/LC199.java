package ng.meta;

import java.util.*;

public class LC199 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ans.add(root.val);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }

            }
            if(!queue.isEmpty()) {
                ans.add(queue.peek().val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(1);
        TreeNode node2  = new TreeNode(2);

        TreeNode node3  = new TreeNode(3);
        TreeNode node4  = new TreeNode(1);
        TreeNode node5  = new TreeNode(5);
        TreeNode node6  = new TreeNode(4);
        TreeNode node7  = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        //node2.left = node4;
        node2.right = node5;
        //node3.left = node6;
        node3.right=node7;
        rightSideView(node1);
    }

}
