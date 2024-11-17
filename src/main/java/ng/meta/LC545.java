package ng.meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LC545 {
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
    public static List<Integer> getBoundary(TreeNode root){
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)){
            ans.add(root.val);
        }
        findLeftBoundary(root.left,ans);
        findLeaves(root,ans);
        findRightBoundary(root.right,ans);

        return ans;
    }

    private static void findLeaves(TreeNode root, List<Integer> leaves) {
        if(root == null){
            return;
        }
        if(isLeaf(root)){
            leaves.add(root.val);
        }
        findLeaves(root.left,leaves);
        findLeaves(root.right,leaves);
    }
    static boolean isLeaf(TreeNode node){

        return node!=null && node.left==null && node.right==null;
    }
    private static void findLeftBoundary(TreeNode left, List<Integer> leftB) {
        if(left == null || isLeaf(left)){
            return;
        }
        leftB.add(left.val);
        if(left.left != null) {
            findLeftBoundary(left.left, leftB);
        }else {
            findLeftBoundary(left.right, leftB);
        }
    }
    private static void findRightBoundary(TreeNode right, List<Integer> rightB) {
        if(right == null || isLeaf(right)){
            return;
        }
        if(right.right!=null) {
            findRightBoundary(right.right, rightB);
        }else {
            findRightBoundary(right.left, rightB);
        }
        rightB.add(right.val);

    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(5);
        TreeNode node2  = new TreeNode(2);

        TreeNode node3  = new TreeNode(9);
        TreeNode node4  = new TreeNode(1);
        TreeNode node5  = new TreeNode(3);
        TreeNode node6  = new TreeNode(7);
        TreeNode node7  = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right=node7;
        getBoundary(node1);
    }
}
