package neetcode;

import java.util.HashMap;

public class Tree {
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
    static TreeNode max = null;

    static public boolean isValidBST(TreeNode root) {
        max = null;
        if(root.left == null && root.right == null){
            return true;
        }
        return checkTree2(root);
    }

    static public boolean checkTree2(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left =checkTree2(root.left);
        if(max!=null && max.val >= root.val) {
            return false;
        }
        max = root;
        boolean right =checkTree2(root.right);
        return  left && right;
    }

    static  int preIdx = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0){
            return null;
        }
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            idxMap.put(inorder[i], i);
        }
        return buildTree(preorder, idxMap, 0, preorder.length - 1);
    }
    public static TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> idxMap, int l, int r) {
        if(l > r){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIdx]);
        int mid = idxMap.get(preorder[preIdx++]);
        root.left = buildTree(preorder, idxMap, l+1, mid - 1 );
        root.right = buildTree(preorder, idxMap, mid + 1, r);
        return root;
    }
    public static void main(String[] args) {
       /* TreeNode node1  = new TreeNode(5);
        TreeNode node2  = new TreeNode(2);

        TreeNode node3  = new TreeNode(9);
        TreeNode node4  = new TreeNode(1);
        TreeNode node5  = new TreeNode(3);
        TreeNode node6  = new TreeNode(4);
        TreeNode node7  = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right=node7;
        System.out.println(isValidBST(node1));*/
        int[] preorder={1,2,3,4};
        int[] inorder={2,1,3,4};
        TreeNode node = buildTree(preorder, inorder);
        System.out.println(node);
    }
}
